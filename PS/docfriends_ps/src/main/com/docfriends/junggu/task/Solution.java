package com.docfriends.junggu.task;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final char BEGIN_ASCII = 48;
    private static final char END_ASCII = 57;

    public int solution(String q) {
        char[] charArray = q.toCharArray();

        List<Integer> numbers = getNumbers(charArray);
        int[] maxAndMin = getIndexOfMaxAndMin(numbers);

        int answer = maxAndMin[0] + maxAndMin[1];

        return answer;
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

        if (number.length() != 0) {
            numbers.add(Integer.parseInt(number.toString()));
        }

        return numbers;
    }

    public int[] getIndexOfMaxAndMin(List<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int minIndex = 0;
        int maxIndex = 0;

        int index = 0;
        for (int number : numbers) {
            if (min > number) {
                min = number;
                minIndex = index;
            }

            if (max < number) {
                max = number;
                maxIndex = index;
            }

            ++index;
        }

        return new int[] {maxIndex, minIndex};
    }
}
