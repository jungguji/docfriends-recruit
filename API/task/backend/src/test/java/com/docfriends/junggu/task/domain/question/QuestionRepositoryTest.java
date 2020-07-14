package com.docfriends.junggu.task.domain.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class QuestionRepositoryTest {

    @Autowired
    QuestionRepository questionRepository;

    LocalDateTime time;
    LocalDateTime time1;
    LocalDateTime answerTime;


    private static final String Q1_TITLE = "수원 24/남 여드름, 피부가 건조하면 등여드름이 잘 생기나요?";
    private static final String Q1_CONTENT = "제가 얼굴이며 몸이며, 피부가 정말 악건성인데...등여드름이 정말 자주 생겨요.\\n\\n바디로션도 꾸준히 바르는데, 심하진 않아도 주기적으로 자잘하게 등여드름이 생기면 어떻게 해결해야 하는거죠? (수원 20대 중반/남 여드름)";

    @BeforeEach
    public void setUp() {
        this.time = LocalDateTime.of(2020, 07,11,19,51,04);
        this.time1 = LocalDateTime.of(2020, 07,11,19,51,05);
        this.answerTime = LocalDateTime.of(2020, 07,11,19,52,28);
    }

    @Test
    void findMainList() {
        //given
        List<Object[]> given = Arrays.asList(
                new Object[]   {1, Q1_TITLE,	Q1_CONTENT,	"tag 01",	time, 2L}
                , new Object[] {3, "광화문 40대중반/남 가슴중앙통증, 역류성 식도염때문에 가슴 중앙 통증이 생길 수 있나요?",	"가슴이 답답하면서 약간 조이는 듯한 가슴 중앙 통증이 있습니다.\\n\\n특히 밤에 자려고 누우면 가슴 중앙 통증이 더 심하게 느껴지는 것 같습니다.\\n\\n심장의 문제인가 걱정이 많이 되었는데 검진 결과 큰 이상은 없었고,\\n\\n위내시경에서 역류성 식도염 진단을 받았습니다.\\n\\n역류성 식도염때문에 가슴 중앙 통증이 생기기도 하나요?",	"tag 03",	time, 1L}
                , new Object[] {4, "성남 분당 20대후반/여 턱관절질환, 사랑니를 뽑은 후에 턱관절에 통증이 있습니다.",	"왼쪽 아래 사랑니 뽑은지 3-4개월이 됐는데도 귀 밑 턱에 통증이 있습니다.\\n\\n손가락 세개가 들어갈 정도로 입도 벌어지고 딱딱 소리가 나지는 않는데 하품할때나 아침에는 뻐근하게 아픕니다.\\n\\n그 치과에 문의해보면 너무 세개 흔들었나?이러십니다.\\n\\n;; 사랑니 뽑기 전에는 턱에 아무문제가 없었습니다.\\n\\n아! 그리고 제가 턱에 보톡스도 맞았습니다.\\n\\n한 6개월전에. 이때도 아무 문제 없었습니다.\\n\\n어쨋든 이런 증상도 턱관절장애 치료를 받아야 되는지요? 아니면 집에서 찜질정도 해줘도 서서히 없어지는 통증인가요?",	"tag 04",	time, 1L}
                , new Object[] {5, "질문글 제목 05",	"질문내용 05",	"tag 05",	time, 1L}
                , new Object[] {6, "질문글 제목 06",	"질문내용 06",	"tag 06",	time1, 1L}
                , new Object[] {7, "질문글 제목 07",	"질문내용 07",	"tag 07",	time1, 1L}
                , new Object[] {8, "질문글 제목 08",	"질문내용 08",	"tag 08",	time1, 1L}
                , new Object[] {9, "질문글 제목 09",	"질문내용 09",	"tag 09",	time1, 1L}
        );

        List<String> columns = new ArrayList<>();
        columns.add("questionId");
        columns.add("questionTitle");
        columns.add("questionContent");
        columns.add("questionTag");
        columns.add("questionCreateDate");
        columns.add("answercCount");

        List<Map<String, Object>> givenList = convertMapList(given, columns);

        //when
        List<Object[]> list = questionRepository.findMainList();
        List<Map<String, Object>> convert = convertMapList(list, columns);

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
        LocalDateTime time1 = LocalDateTime.of(2020, 07,11,19,52,28);

        String a1_content = "안녕하세요, 닥톡-네이버 지식iN 상담한의사 정동원입니다.\\n\\n피부가 건조하면 모공의 입구가 잘 막히게 됩니다.\\n\\n모공의 입구가 막혀버리면 자잘한 좁쌀여드름이 되는 경우가 있습니다.\\n\\n이런 분들이 건조한 피부인데도 좁쌀여드름이 생기는 타입입니다.\\n\\n바디로션이든 알로에젤이나 수딩젤 같은 보습제를 잘 발라주시는 것은 좋습니다.\\n\\n하지만 이미 생긴 등여드름은 절대 뜯지 마세요.\\n\\n자국이나 흉이 생기기 때문입니다.\\n\\n자잘한 등여드름은 압출해서 없애는 방법도 있습니다만, 필링으로 정리하는 방법이 효과적입니다.\\n\\n단시간이 빨리 정리할 수 있기 때문입니다.\\n\\n그외에 땀흘리는 것이 원인일 수 있으므로, 매일 샤워를 해주시는 것도 예방에 도움이 됩니다.\\n\\n감사합니다.";
        String a1_content2 = "안녕하세요, 닥톡-네이버 지식iN 상담한의사 박혜린입니다.\\n\\n여드름 흉터로 고민하고 있으시군요.\\n\\n과거에 제대로 관리되는 않은 여드름으로 인해 피부가 울퉁불퉁하게 패이거나, 붉은자국, 거무칙칙한 색소 등이 흔한 여드름 흉터 증상이며, 정도 및 경과에 따라 다르지만 저절로 회복되기 어려운 흉터들이 많습니다.\\n\\n먼저 패인 흉터에는 크게 세 가지 종류가 있습니다.\\n\\n첫 번째는 송곳 모양 흉터로, 얼음송곳처럼 뾰족한 형태의 여드름 흉터입니다.\\n\\n주로 이마나 미간, 볼 양쪽에 잘 생기며, 모공이 변형 되어 생긴 경우가 많습니다.\\n\\n비교적 치료가 어려운 형태의 흉터이며, 차오르기보다는 경계면이 부드러워지는 효과를 기대할 수 있습니다.\\n\\n두 번째는 둥근 접시 모양 흉터로, 패인 흉터의 경계선이 뚜렷하지 않게 함몰되어 있는 형태입니다.\\n\\n보통 볼의 가장자리와 턱 라인 쪽에 나타나며 니들링 및 기계 치료로 피부의 재생을 유도하며 비교적 치료가 쉬운 흉터입니다.\\n\\n세 번째는 박스 모양 흉터로, 경계면이 뚜렷하게 패인 형태의 흉터를 말합니다.\\n\\n깊이가 깊지 않더라도 경계면이 뚜렷해서 눈에 잘 띄고, 여성분들의 경우 화장을 하면 더 도르라져 보이고 화장이 끼어서 신경을 많이 쓰는 흉터의 형태입니다.\\n\\n박스형 흉터는 일반적인 흉터치료에 부가적으로 특징적으로 흉터 아래 부분의 유착을 제거해주고 재생공간을 유도해 줄 수 있는 치료가 필요합니다.\\n\\n다음은 색소성 흉터로, 붉게 남아있는 여드름 자국이나 갈색으로 변색된 색소침착이 있습니다.\\n\\n붉은 자국은 피부의 손상이 미처 다 재생되지 못하여 붉은 상처가 남아있는 것으로 그 부분의 재생을 유도하여 점점 본래의 색으로 회복시켜야합니다.\\n\\n갈색 색소의 경우 주로 표면의 손상으로 인해 침착된 경우가 많으며, 이 경우에는 색소를 탈락시킬 수 있는 치료가 필요합니다.\\n\\n흉터 치료에 있어서 중요한 것은 흉터의 발생시기, 흉터의 깊이, 환자의 재생력, 나이 등입니다.\\n\\n즉, 흉터 치료를 고민하는 지금 이 순간의 실천이 빠를수록 흉터치료의 속도도 높다고 볼 수 있습니다.\\n\\n빠른 시일 내에 상담 받아 보시고 매끈한 피부를 가지시길 바랍니다";

        List<Object[]> given = Arrays.asList(
                new Object[] {Q1_TITLE,	Q1_CONTENT,	"tag 01",	    time,	a1_content,	answerTime,	"의사 1",	"병원 1",	"서울시 1"}
                , new Object[] {Q1_TITLE,	Q1_CONTENT,	"tag 01",	time,	a1_content2,	answerTime,	"의사 2",	"병원 1",	"서울시 1"}
        );

        List<String> columns = new ArrayList<>();
        columns.add("questionTitle");
        columns.add("questionContent");
        columns.add("questionTag");
        columns.add("answerContent");
        columns.add("answerCreateDate");
        columns.add("doctorName");
        columns.add("hospitalName");
        columns.add("hospitalAddress");

        List<Map<String, Object>> givenList = convertMapList(given, columns);

        //when
        List<Object[]> list = questionRepository.findConsultDetail(1);
        List<Map<String, Object>> convert = convertMapList(list, columns);

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