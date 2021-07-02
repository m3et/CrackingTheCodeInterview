package com.example;

import java.util.HashSet;
import java.util.Set;

import com.example.CICTLibrary.LinkedListNode;

public class Chapter2 {

    private Chapter2() {
        // Utility classes, non-public constructor should be defined to override Java's
        // default public constructor
        throw new IllegalStateException("Utility class");
    }

    /**
     * The method removes any duplicate elements from the list Run time - O(N) Using
     * Set as a buffer - space O(N)
     * 
     * @param list - LinkedListNode
     */
    public static LinkedListNode removeDupsLinkedListNodeA(LinkedListNode head) {
        if (head == null)
            return head;

        LinkedListNode curr;
        LinkedListNode prev;
        curr = head;
        prev = null;

        Set<Integer> set = new HashSet<>();

        while (curr != null) {
            if (set.contains(curr.data)) {
                prev.next = curr.next;
            } else {
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    /**
     * The method removes any duplicate elements from the list , using tow pointer
     * method
     * Run time - O(N^2)
     * Space Complexity O(1)
     * 
     * @param list - LinkedListNode
     */
    public static LinkedListNode removeDupsLinkedListNodeB(LinkedListNode head) {
        if (head == null)
            return head;

        LinkedListNode curr = head;

        while (curr != null) {
            LinkedListNode runner = curr;
            while (runner.next != null) {
                if (runner.next.data == curr.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null); // AssortedMethods.randomLinkedList(1000, 0, 2);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());

        LinkedListNode cloneA = head.clone();
        LinkedListNode cloneB = head.clone();
        LinkedListNode cloneC = head.clone();
        removeDupsLinkedListNodeA(cloneA);
        removeDupsLinkedListNodeA(cloneB);
        removeDupsLinkedListNodeA(cloneC);

        System.out.println(cloneA.printForward());
        System.out.println(cloneB.printForward());
        System.out.println(cloneC.printForward());
    }

}
