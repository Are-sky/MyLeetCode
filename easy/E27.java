package easy;

import java.util.Arrays;

/**
 * 功能描述
 * 27. 移除元素
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 邱彦祥
 * @date: 2023-03-03 18:53
 */
public class E27 {

    //快慢指针
    public static int removeElement(int[] nums, int val) {
        int slow = 0;
        for(int fast = 0;fast < nums.length;++fast) {
            if(nums[fast] != val){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    //首尾指针
    public static int removeElement1(int[] nums, int val){
        int left = 0;
        int right = nums.length - 1;
        while(right >= 0 && nums[right] == val){
            --right;
        }
        while(left <= right){
            if(nums[left] == val){
                nums[left] = nums[right--];
            }
            left++;
            while(right >= 0 && nums[right] == val){
                --right;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int target = 2;
        System.out.println(removeElement(nums,target));
        System.out.println(Arrays.toString(nums));
    }
}
