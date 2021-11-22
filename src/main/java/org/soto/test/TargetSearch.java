package org.soto.test;


/**
 *
 */
public class TargetSearch {

    /**
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 示例 2：
     * <p>
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 示例 3：
     * <p>
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {};
        int target = 6;
        int[] result = solution(nums, target);
        System.out.println(result[0] + "," + result[1]);
    }

    public static int[] solution(int[] nums, int target) {
        // 结果
        int[] result = {-1, -1};
        int len = nums.length;
        if (len == 0) {
            return result;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] == target && result[0] == -1) {
                result[0] = i;
            }
            if (nums[len - i - 1] == target && result[1] == -1) {
                result[1] = len - i - 1;
            }
        }
        return result;
    }
}
