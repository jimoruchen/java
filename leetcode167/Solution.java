package leetcode167;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int left = i + 1, high = numbers.length - 1;
            while (left <= high) {
                int mid = left + (high - left) / 2;
                if (numbers[mid] < target - numbers[i]) {
                    left = mid + 1;
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    return new int[]{i + 1, mid + 1};
                }
            }
        }
        return new int[] {-1, -1};
    }
}
