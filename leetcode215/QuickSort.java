package leetcode215;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 7, 5, 4, 8, 9, 1, 2, 12, 23, 3};
        System.out.println("原始数组:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        quicksort(arr, 0, arr.length - 1);
        System.out.println("\n排序后的数组:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void quicksort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            quicksort(arr, left, partition);
            quicksort(arr, partition +1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int privot = arr[left];
        int l = left - 1;
        int r = right + 1;
        while (l < r) {
            do l++; while (arr[l] < privot);
            do r--; while (arr[r] > privot);
            if (l <r) {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
            }
        }
        return r;
    }
}