## 数组

## 485. 最大连续 1 的个数
### **题目**
给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。

* 示例1：
>输入：nums = [1,1,0,1,1,1]
>输出：3
>解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.

### 代码
```java  
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }
}
```

<hr>

## 283. 移动零
### **题目**
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

* 示例1：
>输入：nums = [0,1,0,3,12]
>输出：[1,3,12,0,0]

### 代码
```java
public class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int cur = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[cur++] = nums[i];
            }
        }
        for (int i = cur; i < length; i++) {
            nums[i] = 0;
        }
    }
}

```

<hr>

## 26. 删除有序数组中的重复项
### **题目**
给你一个非严格递增排列的数组 nums ，请你原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。  
元素的相对顺序应该保持一致 。然后返回nums中唯一元素的个数。

* 示例1：
>输入：nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
>输出：5, nums = [0, 1, 2, 3, 4]

## 代码
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[slow]) {
                nums[++slow] = nums[i];
            }
        }
        return slow + 1;
    }
}
```

<hr>

## 27. 移除元素
### **题目**
给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。

* 示例1：
>输入：nums = [3, 2, 2, 3], val = 3   
>输出：2, nums = [2, 2, _, _]
>解释：你的函数函数应该返回 k = 2, 并且 nums 中的前两个元素均为 2。

## 代码
```java
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)   return 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[left] = nums[i];
                left++;
            }
        }
        return left;
    }
}
```

<hr>


## 链表

## 19. 删除链表的倒数第 N 个结点
### **题目**
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

* 示例1：
>输入：head = [1,2,3,4,5], n = 2
>输出：[1,2,3,5]

### 代码
```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = head;
        ListNode cur = dummy;
        int len = 0;
        while (prev != null) {
            prev = prev.next;
            len++;
        }
        for (int i = 0; i < len - n; i++)
            cur = cur.next;
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
```

<hr>

## 24. 两两交换链表中的节点
### **题目**
给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

* 示例1：
>输入：head = [1,2,3,4]
>输出：[2,1,4,3]

## 代码
```java
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = first.next;
            ListNode third = second.next;
            cur.next = second;
            second.next = first;
            first.next = third;
            cur = first;
        }
        return dummy.next;
    }
}
```

<hr>

## 160. 相交链表
### 题目
编写一个程序，找到两个单链表相交的起始节点。  
<img src="https://s2.loli.net/2025/08/21/XEGihx6WsZFHcqo.png" >  
在节点 c1 开始相交。

### 代码
```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = headA;
        while (cur != null) {
            set.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
```
```java
public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
```

<hr>

## 203. 移除链表元素
### 题目
给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。

* 示例1：

>输入: head = [1,2,6,3,4,5,6], val = 6
>输出: [1,2,3,4,5]

### 代码
```java
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
```
```java
public class Solution1 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
```

<hr>
