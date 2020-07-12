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
                new Object[]   {1, "질문글 제목 01",	"질문내용 01",	"tag 01",	time, 2L}
                , new Object[] {3, "질문글 제목 03",	"질문내용 03",	"tag 03",	time, 1L}
                , new Object[] {4, "질문글 제목 04",	"질문내용 04",	"tag 04",	time, 1L}
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

        List<Object[]> given = Arrays.asList(
                new Object[] {"질문글 제목 01",	"질문내용 01",	"tag 01",	    time,	"답글답글답글 1",	answerTime,	"의사 1",	"병원 1",	"서울시 1"}
                , new Object[] {"질문글 제목 01",	"질문내용 01",	"tag 01",	time,	"답글답글답글 2",	answerTime,	"의사 2",	"병원 1",	"서울시 1"}
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