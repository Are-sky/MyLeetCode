package easy;

/**
 * 功能描述
 *
 * 704. 二分查找
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: 邱彦祥
 * @date: 2023-03-03 15:44
 */
public class E704 {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //区间左闭右闭
        while(left <= right){
            int mid = left + ((right-left) >> 1);
            if (nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //区间左闭右开
        while(left < right){
            int mid = left + ((right-left) >> 1);
            if (nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }


    public static void main(String[] args){
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        System.out.println(search(nums,target));
    }
}
