package com.docfriends.junggu.task.domain.question;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class QuestionRepositoryTest {

    @Autowired
    QuestionRepository questionRepository;

    @Test
    void findMainList() {
        //given
        List<Object[]> given = Arrays.asList(
                new Object[] {"질문글 제목 01",	"질문내용 01",	"tag 01",	    "2020-07-11T19:51:04",	"답글답글답글 1",	"2020-07-11T19:52:28",	"의사 1",	"병원 1",	"서울시 1",	"website_url 1"}
                , new Object[] {"질문글 제목 01",	"질문내용 01",	"tag 01",	"2020-07-11T19:51:04",	"답글답글답글 2",	"2020-07-11T19:52:28",	"의사 1",	"병원 1",	"서울시 1",	"website_url 1"}
                , new Object[] {"질문글 제목 03",	"질문내용 03",	"tag 03",	"2020-07-11T19:51:04",	"답글답글답글 3",	"2020-07-11T19:52:28",	"의사 3",	"병원 1",	"서울시 1",	"website_url 1"}
                , new Object[] {"질문글 제목 04",	"질문내용 04",	"tag 04",	"2020-07-11T19:51:04",	"답글답글답글 4",	"2020-07-11T19:52:28",	"의사 4",	"병원 2",	"부산 2",	"website_url 2"}
                , new Object[] {"질문글 제목 05",	"질문내용 05",	"tag 05",	"2020-07-11T19:51:04",	"답글답글답글 5",	"2020-07-11T19:52:28",	"의사 4",	"병원 2",	"부산 2",	"website_url 2"}
                , new Object[] {"질문글 제목 06",	"질문내용 06",	"tag 06",	"2020-07-11T19:51:05",	"답글답글답글 6",	"2020-07-11T19:52:28",	"의사 2",	"병원 1",	"서울시 1",	"website_url 1"}
                , new Object[] {"질문글 제목 07",	"질문내용 07",	"tag 07",	"2020-07-11T19:51:05",	"답글답글답글 7",	"2020-07-11T19:52:28",	"의사 2",	"병원 1",	"서울시 1",	"website_url 1"}
                , new Object[] {"질문글 제목 08",	"질문내용 08",	"tag 08",	"2020-07-11T19:51:05",	"답글답글답글 8",	"2020-07-11T19:52:28",	"의사 1",	"병원 1",	"서울시 1",	"website_url 1"}
                , new Object[] {"질문글 제목 09",	"질문내용 09",	"tag 09",	"2020-07-11T19:51:05",	"답글답글답글 9",	"2020-07-11T19:52:28",	"의사 3",	"병원 1",	"서울시 1",	"website_url 1"}
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
        columns.add("hospitalWebsiteUrl");

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


}