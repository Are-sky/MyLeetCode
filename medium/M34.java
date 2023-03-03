package medium;

import java.util.Arrays;

/**
 * 功能描述
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 邱彦祥
 * @date: 2023-03-03 18:24
 */
public class M34 {
    public static int[] searchRange(int[] nums, int target) {
        int leftBorder = searchL(nums, target);
        int rightBorder = searchR(nums, target);
        // 情况一
        if (leftBorder == -2 || rightBorder == -2) {
            return new int[]{-1, -1};
        }
        // 情况三
        if (rightBorder - leftBorder > 1) {
            return new int[]{leftBorder + 1, rightBorder - 1};
        }
        // 情况二
        return new int[]{-1, -1};
    }

    //找右边界
    public static int searchR(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int r = -2;
        int mid = 0;
        while(left <= right){
            mid = left + ((right - left) >> 1);
            if (nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
                r = left;
            }
        }
        return r;
    }
    //找左边界
    public static int searchL(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int l = -2;
        int mid = 0;
        while(left <= right){
            mid = left + ((right - left) >> 1);
            if (nums[mid] >= target){
                right = mid - 1;
                l = right;
            }else {
                left = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
