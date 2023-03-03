package easy;

/**
 * 功能描述
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author:  邱彦祥
 * @date: 2023-03-03 17:52
 */
public class E35 {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left <= right){
            mid = left + ((right - left) >> 1);
            if (nums[mid] > target){
                 right = mid - 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return right + 1;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(nums,target));
    }
}
