package leetcode.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateRemovalSolution {

    public static int execute2(int[] nums) {
        if (nums == null || nums.length <= 0 || nums.length > 3 * Math.pow(10, 4)) {
            return 0;
        }

        //慢指针
        int newLen = 0;
        //快指针
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < -Math.pow(10, 4) || nums[i] > Math.pow(10, 4)) {
                continue;
            }

            if (nums[newLen] != nums[i]) {
                newLen++;
                nums[newLen] = nums[i];
            }
        }
        return newLen + 1;
    }

    public static int execute(int[] nums) {
        if (nums == null || nums.length <= 0 || nums.length > 3 * Math.pow(10, 4)) {
            return 0;
        }

        int[] unDuplicatedNums = new int[nums.length];
        int newLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < -Math.pow(10, 4) || nums[i] > Math.pow(10, 4)) {
                continue;
            }

            if (i + 1 > nums.length - 1) {
                unDuplicatedNums[newLen++] = nums[i];
                break;
            }

            if (nums[i] != nums[i + 1]) {
                unDuplicatedNums[newLen++] = nums[i];
            }
        }
        System.arraycopy(unDuplicatedNums, 0, nums, 0, nums.length);
        return newLen;
    }

    public static void main(String[] args) {
//        System.out.println(3 * Math.pow(10, 4));
        int[] nums1 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        List<Integer> nums = new ArrayList<>();
        nums.add(0);
        nums.add(1);
        nums.add(2);

        Map<String,Object> map = new HashMap<>();
        map.put("nums_1",nums1);
        map.put("nums_2",nums);
//        DuplicateRemovalSolution.execute2(nums1);
//        System.out.println(nums1);
//
//        int[] nums2 = new int[]{1, 1, 2};
//        DuplicateRemovalSolution.execute2(nums2);
//        System.out.println(nums2);
//
//        int[] nums3 = new int[]{1, 2, 3};
//        DuplicateRemovalSolution.execute2(nums3);
//        System.out.println(nums3);
//
//        int[] nums4 = new int[]{1, 1, 2, 3};
//        DuplicateRemovalSolution.execute2(nums4);
//        System.out.println(nums4);
    }
}
