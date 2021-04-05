package leetcode.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

public class MasterIsYuri {
    public static void reorderList(ListNode head) {

    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        int longestLen = 0;

        for (int i = 0; i < s.length(); i++) {
            int item = s.charAt(i);
            if (queue.contains(item)) {
                while (queue.peekFirst() != item) {
                    queue.removeFirst();
                }
                queue.removeFirst();
            }
            queue.add(item);

            if (queue.size() > longestLen) {
                longestLen = queue.size();
            }
        }

        return Math.max(longestLen, queue.size());
    }

    public static void main(String[] args) {
        System.out.println(Double.valueOf(8.895));
    }
}
