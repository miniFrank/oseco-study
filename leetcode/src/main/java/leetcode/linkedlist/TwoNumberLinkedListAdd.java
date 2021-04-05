package leetcode.linkedlist;

public class TwoNumberLinkedListAdd {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumListNode = null;
        ListNode leftNode = l1;
        ListNode rightNode = l2;
        ListNode last = null;
        int tenFlag = 0;
        while (leftNode != null && rightNode != null) {
            ListNode l = last;
            int sum = leftNode.val + rightNode.val + tenFlag;
            ListNode newNode = new ListNode(sum > 9 ? sum % 10 : sum);
            if (sum > 9) {
                tenFlag = 1;
            } else {
                tenFlag = 0;
            }
            last = newNode;
            if (l == null)
                sumListNode = newNode;
            else
                l.next = newNode;

            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }

        if (tenFlag == 1) {
            last.next = new ListNode(tenFlag);
        }

        return sumListNode;
    }

    public static void main(String[] args) {
        System.out.println(18 % 10);
    }
}
