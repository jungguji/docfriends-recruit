package com.docfriends.junggu.task.domain.question;

import com.docfriends.junggu.task.domain.answer.Answer;
import com.docfriends.junggu.task.domain.answer.AnswerRepository;
import com.docfriends.junggu.task.domain.hospital.Hospital;
import com.docfriends.junggu.task.domain.hospital.HospitalRepository;
import com.docfriends.junggu.task.domain.user.doctor.Doctor;
import com.docfriends.junggu.task.domain.user.doctor.DoctorRepository;
import com.docfriends.junggu.task.domain.user.general.GeneralUser;
import com.docfriends.junggu.task.domain.user.general.GeneralUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
class QuestionRepositoryTest {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    GeneralUserRepository generalUserRepository;

    @Autowired
    HospitalRepository hospitalRepository;

    private static final String Q1_TITLE = "수원 24/남 여드름, 피부가 건조하면 등여드름이 잘 생기나요?";
    private static final String Q1_CONTENT = "제가 얼굴이며 몸이며, 피부가 정말 악건성인데...등여드름이 정말 자주 생겨요.\\n\\n바디로션도 꾸준히 바르는데, 심하진 않아도 주기적으로 자잘하게 등여드름이 생기면 어떻게 해결해야 하는거죠? (수원 20대 중반/남 여드름)";
    private static final String Q1_TAG = "#태그, #태그1, #태그2";
    private static final String A1_CONTENT = "안녕하세요, 닥톡-네이버 지식iN 상담한의사 정동원입니다.";
    private static final String H_NAME = "병원";
    private static final String H_ADDR = "서울시";

    LocalDateTime time;
    LocalDateTime answerTime;

    GeneralUser givenUser;
    Answer givenAnswer;
    Doctor doctor;
    Question question;
    Hospital hospital;

    @BeforeEach
    public void setUp() {
        this.time = LocalDateTime.of(2020, 07,11,19,51,04);
        this.answerTime = LocalDateTime.of(2020, 07,11,19,52,28);

        createGeneralUser();
        createQuestion();
        createHospital();
        createDoctor();
        createAnswer();

        question.addAnswer(givenAnswer);
    }

    @AfterEach
    void after() {
        answerRepository.deleteAll();
        doctorRepository.deleteAll();
        hospitalRepository.deleteAll();
        questionRepository.deleteAll();
        generalUserRepository.deleteAll();
    }

    private void createGeneralUser() {
        String userId = "일반유저";
        String pw = "일반비밀번호";
        String name = "지중구";

        givenUser = GeneralUser.builder()
                .userId(userId)
                .password(pw)
                .name(name)
                .build();

        generalUserRepository.save(givenUser);
    }

    private void createQuestion() {
        question = Question.builder()
                .title(Q1_TITLE)
                .content(Q1_CONTENT)
                .tag(Q1_TAG)
                .createDate(time)
                .generalUser(givenUser)
                .answers(new ArrayList<>())
                .build();

        questionRepository.save(question);
    }

    private void createHospital() {
        hospital = Hospital.builder()
                .name(H_NAME)
                .address(H_ADDR)
                .doctors(new ArrayList<>())
                .build();

        hospitalRepository.save(hospital);
    }

    private void createDoctor() {
        doctor = Doctor.builder()
                .userId("qqq")
                .name("의사")
                .password("ps")
                .hospital(hospital)
                .build();

        doctorRepository.save(doctor);
    }

    private void createAnswer() {
        givenAnswer = Answer.builder()
                .content(A1_CONTENT)
                .createDate(answerTime)
                .question(question)
                .doctor(doctor)
                .build();

        answerRepository.save(givenAnswer);
    }



    @Test
    void findMainList() {
        //given
        List<Object[]> given = new ArrayList<>();
        given.add(new Object[]   {this.question.getId(), Q1_TITLE,	Q1_CONTENT,	Q1_TAG,	time, 1L});

        List<String> columns = new ArrayList<>();
        columns.add("questionId");
        columns.add("questionTitle");
        columns.add("questionContent");
        columns.add("questionTag");
        columns.add("questionCreateDate");
        columns.add("answerCount");

        List<Map<String, Object>> givenList = convertMapList(given, columns);

        //when
        List<Object[]> list = questionRepository.findMainList();
        List<Map<String, Object>> convert = convertMapList(list, columns);


        assertThat(list).contains(given.get(0));

        //than
        for (int i = 0; i < convert.size(); i++) {
            Map<String, Object> target = convert.get(i);
            Map<String, Object> givenMap = givenList.get(i);

            for (String key : columns) {
                assertEquals(givenMap.get(key), target.get(key));
            }
        }
    }

    private List<Map<String, Object>> convertMapList(List<Object[]> resultList, List<String> columns) {
        List<Map<String,Object>> mapList = new ArrayList<>();
        Map<String, Object> itemMap;

        for (Object[] item : resultList) {
            itemMap = new HashMap<>();
            int idx = 0;

            for (String key : columns) {
                itemMap.put(key, item[idx++]);
            }
            mapList.add(itemMap);
        }
        return mapList;
    }

    @Test
    void findConsultDetail() {
        //given
        String a1_content2 = "안녕하세요, 닥톡-네이버 지식iN 상담한의사 박혜린입니다.";

        List<Object[]> given = Arrays.asList(
                new Object[] {Q1_TITLE,	Q1_CONTENT,	Q1_TAG,	    time,	A1_CONTENT,	answerTime,	"의사",	H_NAME,	H_ADDR}
                , new Object[] {Q1_TITLE,	Q1_CONTENT,	Q1_TAG,	time,	a1_content2,	answerTime,	"의사 선생님",	H_NAME,	H_ADDR}
        );

        Doctor doctor = Doctor.builder()
                .userId("의사2")
                .name("의사 선생님")
                .password("ps")
                .hospital(hospital)
                .build();

        doctorRepository.save(doctor);

        Answer answer = Answer.builder()
                .content(a1_content2)
                .createDate(answerTime)
                .question(question)
                .doctor(doctor)
                .build();

        answerRepository.save(answer);

        question.addAnswer(answer);

        List<String> columns = new ArrayList<>();
        columns.add("questionTitle");
        columns.add("questionContent");
        columns.add("questionTag");
        columns.add("questionCreateDate");
        columns.add("answerContent");
        columns.add("answerCreateDate");
        columns.add("doctorName");
        columns.add("hospitalName");
        columns.add("hospitalAddress");

        List<Map<String, Object>> givenList = convertMapList(given, columns);

        questionRepository.save(question);

        //when
        List<Object[]> list = questionRepository.findConsultDetail(question.getId());
        List<Map<String, Object>> convert = convertMapList(list, columns);

        assertThat(convert).contains(givenList.get(0))
                .contains(givenList.get(1));

        //than
        for (int i = 0; i < convert.size(); i++) {
            Map<String, Object> target = convert.get(i);
            Map<String, Object> givenMap = givenList.get(i);

            for (String key : columns) {
                assertEquals(givenMap.get(key), target.get(key));
            }
        }
    }
}