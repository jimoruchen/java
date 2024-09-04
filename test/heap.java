package test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class heap {
    public static void main(String[] args) {
        int nums[] = {1, 7, 6, 3, 2};
        Queue<Integer> queue = topKHeap(nums, 3);
        for (int i = 0; i < 3; i++)
            System.out.println(queue.poll());
    }

    public static Queue<Integer> topKHeap(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            heap.add(nums[i]);
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap;
    }
}
