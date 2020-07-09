package com.docfriends.junggu.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private Solution test;
    @BeforeEach
    void setUp() {
        test = new Solution();
    }

    @Test
    void solution() {
        assertEquals(31, test.solution("ab23c4d56e78f9g12h34i5j12k45l67n89m99o1k123p456q567r768s890t67u456v345w234x23y239z"));
        assertEquals(0, test.solution("1"));
        assertEquals(1, test.solution("100a2"));
        assertEquals(10, test.solution("a0a1a2a3a4a5a6a7a8a9a10"));
    }

    @Test
    void getNumbers() {
        int[] expected = new int[] {23, 4, 56, 78, 9, 12, 34, 5, 12, 45, 67, 89, 99, 1, 123, 456, 567, 768, 890, 67, 456, 345, 234, 23, 239};
        int[] actual = test.getNumbers("ab23c4d56e78f9g12h34i5j12k45l67n89m99o1k123p456q567r768s890t67u456v345w234x23y239z".toCharArray()).stream().mapToInt(i -> i).toArray();

        assertArrayEquals(expected, actual);

        int[] expected1 = new int[] {1};
        int[] actual1 = test.getNumbers("1".toCharArray()).stream().mapToInt(i -> i).toArray();

        assertArrayEquals(expected1, actual1);

        int[] expected2 = new int[] {100, 2};
        int[] actual2 = test.getNumbers("100a2".toCharArray()).stream().mapToInt(i -> i).toArray();

        assertArrayEquals(expected2, actual2);

        int[] expected3 = new int[] {0,1,2,3,4,5,6,7,8,9,10};
        int[] actual3 = test.getNumbers("a0a1a2a3a4a5a6a7a8a9a10".toCharArray()).stream().mapToInt(i -> i).toArray();

        assertArrayEquals(expected3, actual3);
    }

    @Test
    void getIndexOfMaxAndMin() {
        assertArrayEquals(new int[] {13, 18}, test.getIndexOfMaxAndMin(test.getNumbers("ab23c4d56e78f9g12h34i5j12k45l67n89m99o1k123p456q567r768s890t67u456v345w234x23y239z".toCharArray())));
        assertArrayEquals(new int[] {0, 0}, test.getIndexOfMaxAndMin(test.getNumbers("1".toCharArray())));
        assertArrayEquals(new int[] {0, 1}, test.getIndexOfMaxAndMin(test.getNumbers("100a2".toCharArray())));
        assertArrayEquals(new int[] {10, 0}, test.getIndexOfMaxAndMin(test.getNumbers("a0a1a2a3a4a5a6a7a8a9a10".toCharArray())));
    }
}