package test;

public class LinkedListStack {
    private ListNode stackPeek;
    private int stksize = 0;

    public LinkedListStack() {
        stackPeek = null;
    }

    public int size() {
        return stksize;
    }

    public boolean isEmpty() {
        return stksize == 0;
    }

    public void push(int num) {
        ListNode node = new ListNode(num);
        node.next = stackPeek;
        stackPeek = node;
        stksize++;
    }

    public int pop() {
        int num = stackPeek.val;
        stackPeek = stackPeek.next;
        stksize--;
        return num;
    }

    public int peek() {
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        return stackPeek.val;
    }

    public int[] toArray() {
        ListNode node = stackPeek;
        int[] nums = new int[size()];
        for (int i = size() - 1; i >= 0; i--) {
            nums[i] = node.val;
            node = node.next;
        }
        return nums;
    }
}
