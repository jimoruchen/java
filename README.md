# **leetcode**  

## **1.两数之和**  
### **题目**
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。

* 示例1：  
>输入：nums = [2,7,11,15], target = 9    
>输出：[0,1]  
>解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。


* 示例2：  
>输入：nums = [3,2,4], target = 6  
>输出：[1,2]`


* 示例3：  
>输入：nums = [3,3], target = 6  
>输出：[0,1]  

### **代码**  
* 返回一对数组中满足target的值的下标
```java
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i]))
                return new int[] {map.get(target - nums[i]), i};
            else map.put(nums[i], i);
        }
        return new int[0];
    }
}
```   
> 将nums的下标存储为map的值，nums的值存储为map的键，查找map中是否含有满足target - nums[i]的键，
> 有则返回对应的下标对，不含有则将值加入map中。

<hr>  

* 返回所有数组中满足target的值的下标  
```java
public class Solution2 {
    public List<int[]> twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                int j = map.get(complement);
                if (j != i) {
                    result.add(new int[]{j, i});
                }
            }
            map.put(nums[i], i);
        }
        return result.isEmpty() ? null : result;
    }
}
```

> 同上，但是将所有满足条件的下标对加入到List中


<hr>


## **2.两数相加**
### **题目**
给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。你可以假设除了数字0之外，
这两个数都不会以0开头。

* 示例1：    
<img  style="height: 250px;width: 300px" src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/01/02/addtwonumber1.jpg">  
> 输入：l1 = [2,4,3], l2 = [5,6,4]  
>输出：[7,0,8]  
>解释：342 + 465 = 807  


* 示例2：  
>输入：l1 = [0], l2 = [0]  
>输出：[0]


* 示例3：  
>输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]  
>输出：[8,9,9,9,0,0,0,1]

### **代码**

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode p = head;
        int carry = 0;
        while(l1 != null || l2 != null) {
            if(l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry % 10);
            p = p.next;
            carry = carry / 10;
        }
        if(carry > 0)
            p.next = new ListNode(carry);
        return head.next;
    }
}
```  
从个位开始，将加起来的值取余后放在节点中，除10后进位。  
当l1和l2长度不相等时，最后将carry除10后再新建节点并加载链表尾端。
