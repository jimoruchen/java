package leetcode15;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = solution.threeSum(arr);
        for (List<Integer> innerList : lists) {
            for (Integer number : innerList)
                System.out.print(number + " ");
            System.out.println();
        }
    }
}
