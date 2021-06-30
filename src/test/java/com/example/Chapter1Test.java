package com.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Chapter1Test {

    @Test
    public void isUnique() {
        assertTrue(Chapter1.isUnique("qwe"));
        assertTrue(Chapter1.isUnique(""));
        assertFalse(Chapter1.isUnique("  "));
        assertFalse(Chapter1.isUnique("--"));
        assertFalse(Chapter1.isUnique("qeq"));
    }

    @Test
    void checkPermutation() {
        assertTrue(Chapter1.checkPermutation("god", "god"));
        assertTrue(Chapter1.checkPermutation("", ""));
        assertTrue(Chapter1.checkPermutation("  ", "  "));
        assertFalse(Chapter1.checkPermutation("God", "god"));
        assertFalse(Chapter1.checkPermutation("G", "g"));
    }

    @Test
    void isPalindromePermutation() {
        assertTrue(Chapter1.isPalindromePermutation("taco cat"));
        assertTrue(Chapter1.isPalindromePermutation("dad"));
        assertTrue(Chapter1.isPalindromePermutation("reiv ver"));

    }

    @Test
    void isOneAway() {
        assertTrue((Chapter1.isOneAway("pale", "pale")));
        assertTrue((Chapter1.isOneAway("pale", "ple")));
        assertTrue((Chapter1.isOneAway("ple", "pale")));
        assertTrue((Chapter1.isOneAway("", "")));

        assertFalse(Chapter1.isOneAway("palee", "pal"));
        assertFalse(Chapter1.isOneAway("p", "pal"));
        assertFalse(Chapter1.isOneAway("", "pal"));
    }

    @Test
    void zeroMatrix() {
        int[][] mat = { { 1, 1, 1, 1, 1 }, { 1, 1, 0, 1, 1 }, { 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1 } };
        Chapter1.zeroMatrix(mat);
        int[][] res = { { 0, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 } };

        assertArrayEquals(mat, res);

        int[][] mat1 = {};
        Chapter1.zeroMatrix(mat);
        int[][] res1 = {};

        assertArrayEquals(mat1, res1);

        int[][] mat2 = { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 } };
        Chapter1.zeroMatrix(mat);
        int[][] res2 = { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 } };

        assertArrayEquals(mat2, res2);

    }

}