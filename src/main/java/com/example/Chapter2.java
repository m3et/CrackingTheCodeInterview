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
     * method Run time - O(N^2) Space Complexity O(1)
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

    /**
     * Q 2.3
     * 
     * @param head of LinkedList
     * @param k
     * @return thr kth element from last if Len(List) > k else return null Iterative
     *         solution takes O(N) time and O(1) space
     */
    public static LinkedListNode kthFromLast(LinkedListNode head, int k) {
        LinkedListNode curr = head;
        LinkedListNode runner = head;

        for (int i = 0; i < k; ++i) {
            if (runner == null)
                return null;
            runner = runner.next;
        }
        while (runner != null) {
            curr = curr.next;
            runner = runner.next;
        }
        return curr;
    }


    /**
     * 
     * @param node 
     * @param x value to partition list 
     * @return LinkedListNode head such that all node less then x come befor all nodes grater than or equals to x
     */
    // TODO: you didnt mannaged to do it....
    public static LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while (node != null) {
            LinkedListNode next = node.next;

            if (node.data < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }

        tail.next = null;
        return head;
    }

    // public static LinkedListNode sumLists(LinkedListNode l1, LinkedListNode l2) {

    //     while (l1 != null || l2 != null) {
    //         int a = 
    //     }

        
    // }

}
