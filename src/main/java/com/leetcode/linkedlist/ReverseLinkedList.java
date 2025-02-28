package com.leetcode.linkedlist;


public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode list = generateList(5);
        printList(list);
        ListNode reversedList = reverseList(list);
        printList(reversedList);
    }


    private static ListNode reverseList(ListNode head) {
        ListNode ptr = head;
        ListNode prev = null;
        while (ptr != null) {
            ListNode nextElement = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = nextElement;
        }
        return prev;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static ListNode generateList(int size) {
        ListNode prev = null;
        ListNode head = null;
        for (int i = 1; i <= size; i++) {
            ListNode node = new ListNode(i);
            if (i == 1) {
                head = node;
            } else {
                prev.next = node;
            }
            prev = node;
        }
        return head;
    }

    private static void printList(ListNode list) {
        ListNode ptr = list;

        while (ptr != null) {
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
        System.out.println("");
    }
}



