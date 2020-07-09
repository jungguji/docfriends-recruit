package com.docfriends.junggu.task;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final char BEGIN_ASCII = 48;
    private static final char END_ASCII = 57;

    public int solution(String q) {
        char[] charArray = q.toCharArray();

        List<Integer> numbers = getNumbers(charArray);

        return 0;
    }

    public List<Integer> getNumbers(char[] charArray) {
        List<Integer> numbers = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        for (char ch : charArray) {
            boolean isNumber = false;

            if (ch >= BEGIN_ASCII && ch <= END_ASCII) {
                isNumber = true;
                number.append(ch);
            }

            if (!isNumber && number.length() != 0) {
                numbers.add(Integer.parseInt(number.toString()));
                number.setLength(0);
            }
        }

        return numbers;
    }
}
