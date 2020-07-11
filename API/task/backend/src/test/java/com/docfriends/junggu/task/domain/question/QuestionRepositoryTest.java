package com.docfriends.junggu.task.domain.question;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
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
        LocalDateTime time = LocalDateTime.of(2020, 07,11,19,51,04);
        LocalDateTime time1 = LocalDateTime.of(2020, 07,11,19,51,05);
        LocalDateTime time2 = LocalDateTime.of(2020, 07,11,19,52,28);

        List<Object[]> given = Arrays.asList(
                new Object[] {"질문글 제목 01",	"질문내용 01",	"tag 01",	    time,	"답글답글답글 1",	time2,	"의사 1",	"병원 1",	"서울시 1",	"website_url 1"}
                , new Object[] {"질문글 제목 01",	"질문내용 01",	"tag 01",	time,	"답글답글답글 2",	time2,	"의사 1",	"병원 1",	"서울시 1",	"website_url 1"}
                , new Object[] {"질문글 제목 03",	"질문내용 03",	"tag 03",	time,	"답글답글답글 3",	time2,	"의사 3",	"병원 1",	"서울시 1",	"website_url 1"}
                , new Object[] {"질문글 제목 04",	"질문내용 04",	"tag 04",	time,	"답글답글답글 4",	time2,	"의사 4",	"병원 2",	"부산 2",	"website_url 2"}
                , new Object[] {"질문글 제목 05",	"질문내용 05",	"tag 05",	time,	"답글답글답글 5",	time2,	"의사 4",	"병원 2",	"부산 2",	"website_url 2"}
                , new Object[] {"질문글 제목 06",	"질문내용 06",	"tag 06",	time1,	"답글답글답글 6",	time2,	"의사 2",	"병원 1",	"서울시 1",	"website_url 1"}
                , new Object[] {"질문글 제목 07",	"질문내용 07",	"tag 07",	time1,	"답글답글답글 7",	time2,	"의사 2",	"병원 1",	"서울시 1",	"website_url 1"}
                , new Object[] {"질문글 제목 08",	"질문내용 08",	"tag 08",	time1,	"답글답글답글 8",	time2,	"의사 1",	"병원 1",	"서울시 1",	"website_url 1"}
                , new Object[] {"질문글 제목 09",	"질문내용 09",	"tag 09",	time1,	"답글답글답글 9",	time2,	"의사 3",	"병원 1",	"서울시 1",	"website_url 1"}
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