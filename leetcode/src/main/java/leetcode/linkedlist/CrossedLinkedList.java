package leetcode.linkedlist;

import java.util.Stack;

public class CrossedLinkedList {
    public static ListNode getIntersectionNode(Integer intersectVal, ListNode headA, ListNode headB, Integer skipA, Integer skipB) {
        Stack<Integer> headAStack = new Stack<>();
        Stack<Integer> headBStack = new Stack<>();
        ListNode currentHA = headA;
        ListNode currentHB = headB;
        while (currentHA != null || currentHB != null) {
            if (skipA-- > 0 && currentHA != null) {
                headAStack.push(currentHA.val);
                currentHA = currentHA.next;
            }
            if (skipB-- > 0 && currentHB != null) {
                headBStack.push(currentHB.val);
                currentHB = currentHB.next;
            }
        }

        Integer headANum = null;
        Integer headBNum = null;
        while (!headAStack.isEmpty() && !headBStack.isEmpty()) {

            Integer headANumTmp = headAStack.pop();
            Integer headBNumTmp = headBStack.pop();
            if (!headANumTmp.equals(headBNumTmp))
                break;
            headANum = headANumTmp;
            headBNum = headBNumTmp;
        }

        if (headBNum != null && headANum.equals(headBNum)) {
            return new ListNode(headANum);
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
