package com.example;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashSet;
import java.util.Set;

import com.example.CICTLibrary.LinkedListNode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

public class Chapter2Test {
    static final int listSize = 100;

    private LinkedListNode head;
    
    @BeforeEach
    public void SetUp() {
        head = new LinkedListNode(1, null, null);
        LinkedListNode first = head;
        LinkedListNode second = head;

        for (int i = 2; i <= listSize; i++) {
            second = new LinkedListNode(i, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
    }

    @Test
    void kthFromLast() {
        assertEquals(100, Chapter2.kthFromLast(head, 1).data);
        assertEquals(1, Chapter2.kthFromLast(head, 100).data);
        assertNull(Chapter2.kthFromLast(head, 101));
    }

    @Nested
    class removeDupsLinkedListNodeTest {

        private LinkedListNode head;

        @BeforeEach
        public void SetUp() {
            head = new LinkedListNode(0, null, null);
            LinkedListNode first = head;
            LinkedListNode second = head;

            for (int i = 1; i < listSize; i++) {
                second = new LinkedListNode(i % (listSize / 2), null, null);
                first.setNext(second);
                second.setPrevious(first);
                first = second;
            }

            // System.out.println(head.printForward());
        }

        @Test
        void removeDupsLinkedListNodeA() {

            Set<Integer> set = new HashSet<Integer>();
            LinkedListNode curr = head;
            Chapter2.removeDupsLinkedListNodeA(curr);
            while (curr != null) {
                assertFalse(set.contains(curr.data));
                set.add(curr.data);
                curr = curr.next;
            }

            // System.out.println(head.printForward());
            // assertTrue(true);

        }

        @Test
        void removeDupsLinkedListNodeB() {

            Set<Integer> set = new HashSet<Integer>();
            LinkedListNode curr = head;
            Chapter2.removeDupsLinkedListNodeB(curr);
            while (curr != null) {
                assertFalse(set.contains(curr.data));
                set.add(curr.data);
                curr = curr.next;
            }

            // System.out.println(head.printForward());
            // assertTrue(true);

        }
    }

}
