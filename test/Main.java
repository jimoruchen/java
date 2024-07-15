package test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++)
            nums[i] = sc.nextInt();
        int[] nums2 = bubblesort(nums);
        for (int num : nums2) {
            System.out.print(num + " ");
        }
    }
    public static int[] bubblesort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length - 1; j++) {
                if(nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
        return nums;
    }
}