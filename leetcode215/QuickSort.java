package leetcode215;

public class QuickSort {
    public static int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return j;
    }

    public static void quicksort(int[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quicksort(arr, l, p - 1);
            quicksort(arr, p + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        quicksort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
