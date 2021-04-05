package leetcode.basic;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosest {
    public static int run(int[] nums, int target) {
        Arrays.sort(nums);
        int loopCounts = nums.length - 3 + 1;
        if (loopCounts == 1) {
            return nums[0] + nums[1] + nums[2];
        }
        int oldSum = 0, newSum;
        int o_i_1 = 0, o_i_2 = 0, o_i_3 = 0;
        int i_1, i_2, i_3, oldSub = 0, newSub;
        int first_time = -1;

        for (int i = 0; i < loopCounts; i++) {
            i_1 = nums[i];
            for (int m = i + 1; m < nums.length - 1; m++) {
                i_2 = nums[m];
                for (int j = m + 1; j < nums.length; j++) {
                    i_3 = nums[j];
                    newSum = i_1 + i_2 + i_3;
                    newSub = newSum - target;
                    if (first_time > 0) {
                        oldSub = oldSum - target;
                        //正整数最小的赋值
                        if (newSub >= 0 && oldSub >= 0) {
                            if (newSub < oldSub) {
                                o_i_1 = i_1;
                                o_i_2 = i_2;
                                o_i_3 = i_3;
                                oldSum = newSum;
                            }
                        } else if (newSub < 0 && oldSub < 0) {
                            if (Math.abs(newSub) < Math.abs(oldSub)) {
                                o_i_1 = i_1;
                                o_i_2 = i_2;
                                o_i_3 = i_3;
                                oldSum = newSum;
                            }
                        } else if (newSub >= 0 && oldSub < 0) {
                            if (newSub < Math.abs(oldSub) + 1) {
                                o_i_1 = i_1;
                                o_i_2 = i_2;
                                o_i_3 = i_3;
                                oldSum = newSum;
                            }
                        } else if (newSub < 0 && oldSub >= 0) {
                            if (Math.abs(newSub) + 1 < oldSub) {
                                o_i_1 = i_1;
                                o_i_2 = i_2;
                                o_i_3 = i_3;
                                oldSum = newSum;
                            }
                        }
                    } else {
                        oldSum = newSum;
                        o_i_1 = i_1;
                        o_i_2 = i_2;
                        o_i_3 = i_3;
                        first_time = 1;
                    }
                    System.out.println(String.format("newSum:%s,oldSum:%s", newSum, oldSum));
                    System.out.println(String.format("newSum:%s,oldSub:%s", newSub, oldSub));
                    System.out.println(String.format("%s,%s,%s", i_1, i_2, i_3));
                }
            }
        }

        return o_i_1 + o_i_2 + o_i_3;
    }

    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(12));
        System.out.println(Integer.toBinaryString(21));
        // -4,-1,2,1
        // -4-1+2,-4-1+1
        // -4+2+1
//        System.out.println(ThreeSumClosest.run(new int[]{-1, 2, 1, -4}, 1));
        //-3,0,1,2
        //0:-3+0+1, -3+0+2,  -3+1+2
        //1:
        //2:
        //0-1-1,   0-1-2,  0-2-3
        //1:0,1,2
//        System.out.println(ThreeSumClosest.run(new int[]{-3, 0, 1, 2}, 1));
//        System.out.println(ThreeSumClosest.run(new int[]{0, 1, 2}, 0));
//        System.out.println(ThreeSumClosest.run(new int[]{-3, 0, 1, 2, -10, -12, 4, 5, 100, 8, 23, 22, -9, -100}, 1));
//        System.out.println(ThreeSumClosest.run(new int[]{1, 1, 1, 1}, 0));
//        System.out.println(ThreeSumClosest.run(new int[]{-5, -4, -3, -2, 3}, 1));
//        System.out.println(ThreeSumClosest.run(new int[]{-5, -4, -3, -2, -1, 2}, 0));
    }
}
