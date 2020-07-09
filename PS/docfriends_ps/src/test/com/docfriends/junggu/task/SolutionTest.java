package com.docfriends.junggu.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}