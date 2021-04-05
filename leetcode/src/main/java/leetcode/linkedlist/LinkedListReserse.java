package leetcode.linkedlist;

import java.util.Stack;


public class LinkedListReserse {
    public static ListNode reverseListSolution1(ListNode head) {
        ListNode current = head;
        Stack<Integer> stack = new Stack<>();

        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        ListNode newListNode = null;
        ListNode last = null;
        while (!stack.isEmpty()) {
            ListNode l = last;
            ListNode newNode = new ListNode(stack.pop());
            last = newNode;
            if (l == null)
                newListNode = newNode;
            else
                l.next = newNode;
        }

        return newListNode;
    }

    public static ListNode create(int capacity) {
        ListNode listNode = null;
        ListNode last = null;
        for (int i = 0; i < capacity; i++) {
            ListNode l = last;
            ListNode newNode = new ListNode(i);
            last = newNode;

            if (l == null) {
                listNode = newNode;
            } else {
                l.next = newNode;
            }
        }

        return listNode;
    }

    public static ListNode createRandom(int capacity) {
        ListNode listNode = null;
        ListNode last = null;
        for (int i = 0; i < capacity; i++) {
            ListNode l = last;
            ListNode newNode = new ListNode((int) (Math.random() * 100));
            last = newNode;

            if (l == null) {
                listNode = newNode;
            } else {
                l.next = newNode;
            }
        }

        return listNode;
    }

    public static void main(String[] args) {
        LinkedListReserse.reverseListSolution1(LinkedListReserse.create(5));
    }
}

