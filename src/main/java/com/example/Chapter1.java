package com.example;

import java.util.*;

/**
 * Chapter 1 Arrays and Strings
 */
class Chapter1 {
    private Chapter1() {
        // Utility classes, non-public constructor should be defined to override Java's default public constructor
        throw new IllegalStateException("Utility class");
      }

    /**
     * Q 1.1
     *
     * @param s string of ASCII char
     * @return true iff all char in s are unique TC: O(n) SC: O(n)
     */
    static boolean isUnique(String s) {
        Set<Character> set = new HashSet<>();
        for (Character c : s.toCharArray()) {
            if (set.contains(c))
                return false;
            set.add(c);
        }
        return true;
    }

    /**
     * Q 1.2
     * 
     * @param s1 string
     * @param s2 string
     * @return true iff s1 is a permutation of s2 Assumption - char are ASCII
     *         encoded otherwise could be implemented using HashMap
     */
    static boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) // stings of different length cant be a permutation of each other
            return false;
        int[] letters = new int[128]; // ASCII assumption

        for (int i = 0; i < s1.length(); ++i) {
            letters[s1.charAt(i)]++;
            letters[s2.charAt(i)]--;
        }

        for (int letter : letters)
            if (letter != 0)
                return false;

        return true;
    }

    /**
     * Q 1.4
     * 
     * @param s string of all ASCII character
     * @return true iff s is a permutation of a palindrome
     *
     */
    static boolean isPalindromePermutation(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (Character ch : s.toCharArray()) {
            if (Character.isLetter(ch))
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        boolean flag = false;
        for (Integer freq : freqMap.values()) {
            if (freq % 2 != 0) {
                if (flag)
                    return false;
                flag = true;
            }
        }

        return true;
    }

    /**
     * Q 1.5
     * 
     * @param first  word
     * @param second word
     * @return True iff s1 is one(or zero) change away allowed change are
     *         replacement adding and removing of a character
     */
    static boolean isOneAway(String first, String second) {
        // more then one change
        if (Math.abs(first.length() - second.length()) > 1)
            return false;

        int index1 = 0;
        int index2 = 0;

        String s1 = first.length() > second.length() ? first : second;
        String s2 = first.length() > second.length() ? second : first;

        boolean foundOneDiff = false;

        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundOneDiff)
                    return false;
                foundOneDiff = true;
                if (s1.length() == s2.length()) {
                    index2++;
                }
            } else {
                index2++;
            }
            index1++;
        }
        return true;
    }

    /**
     * 
     * @param mat M X N matrix For any mat[i][j] == 0 function convert entire i row
     *            and j col to 0
     */
    static void zeroMatrix(int[][] mat) {
        Set<Integer> setRow = new HashSet<>();
        Set<Integer> setCol = new HashSet<>();

        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    setRow.add(i);
                    setCol.add(j);
                }
            }
        }

        for (Integer i : setRow) {
            for (int j = 0; j < col; ++j) {
                mat[i][j] = 0;
            }
        }

        for (Integer j : setCol) {
            for (int i = 0; i < row; ++i) {
                mat[i][j] = 0;
            }
        }
    }
}