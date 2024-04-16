package leetcode01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class leetcode01 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组长度: ");
        int length = scanner.nextInt();
        System.out.println("请输入目标值： ");
        int target = scanner.nextInt();
        int[] arr = new int[length];
        System.out.println("请输入数组的元素：");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(Arrays.toString(solution1.twoSum(arr, target)));

        List<int[]> result = solution2.twoSum(arr, target);
        if (result == null) {
            System.out.println("没有找到和为目标值的元素对。");
        } else {
            System.out.println("找到的和为目标值的元素对下标如下：");
            for (int[] pair : result) {
                System.out.println(Arrays.toString(pair));
            }
        }
        scanner.close();

    }
}
