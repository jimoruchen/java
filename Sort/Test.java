package Sort;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 5};
        quicksort(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.println(num + " ");
        }
    }

    public static void threewayquicksort(int[] arr, int left, int right) {
        if (arr == null || left < 0 || right > arr.length || left > right) {
            return;
        }
        int pivot = arr[left];
        int l = left;
        int r = right;
        int i = left + 1;
        while (i <= r) {
            if (arr[i] < pivot) {
                swap(arr, l++, i++);
            } else if (arr[i] > pivot) {
                swap(arr, i, r--);
            } else {
                i++;
            }
        }
        threewayquicksort(arr, left, l - 1);
        threewayquicksort(arr, r + 1, right);
    }

    public static void quicksort(int[]arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quicksort(arr, left, pivot);
            quicksort(arr, pivot + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int l = left - 1;
        int r = right + 1;
        while (l < r) {
            do l++; while (arr[l] < pivot);
            do r--; while (arr[r] > pivot);
            if (l < r) {
                swap(arr, l, r);
            }
        }
        return r;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
