package medium;

/**
 * 功能描述
 * 209. 长度最小的子数组
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 邱彦祥
 * @date: 2023-03-05 13:30
 */
public class M209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int j = 0; j < nums.length; ++j) {
            sum += nums[j];
            while (sum >= target) {
                result = Math.min(result, j - i + 1);
                sum -= nums[i++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
