package leetcode153;

public class Solution1 {
    public int findMin(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        while (left < right) {      //因为所有元素不相等，当left=right时，说明找到最小元素
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;     //因为已经大于，所以不是最小，所以可以加一
            } else {
                right = mid;        //因为不能排除是最小，所以不能减一
            }
        }
        return nums[left];
    }
}
