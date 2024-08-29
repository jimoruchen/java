package test;

public class LinkedListQueue {
    private ListNode front, rear;
    private int queSize = 0;

    public LinkedListQueue() {
        front = null;
        rear = null;
    }

    public int size() {
        return queSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int peek() {
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        return front.val;
    }

    public void offer(int num) {
        ListNode node = new ListNode(num);
        if(front == null) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        queSize++;
    }

    public int poll() {
        int num = front.val;
        front = front.next;
        queSize--;
        return num;
    }

    public int[] toArray() {
        ListNode node = front;
        int[] nums = new int[queSize];
        for (int i = 0; i < queSize; i++) {
            nums[i] = node.val;
            node = node.next;
        }
        return nums;
    }
}
