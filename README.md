# leetcode 

## 1.两数之和  
### 题目
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

### 代码 
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
将nums的下标存储为map的值，nums的值存储为map的键，查找map中是否含有满足target - nums[i]的键，
有则返回对应的下标对，不含有则将值加入map中。

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
同上，但是将所有满足条件的下标对加入到List中

<hr>

## 2.两数相加
### 题目
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

### 代码

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

<hr>  

## 3.无重复的最长子串
### 题目
给定一个字符串s，请你找出其中不含有重复字符的最长子串的长度。

* 示例1：    

>输入: s = "abcabcbb"  
>输出: 3  
>解释: 因为无重复字符的最长子串是"abc"，所以其长度为3。


* 示例2：
>输入: s = "bbbbb"  
>输出: 1  
>解释: 因为无重复字符的最长子串是"b"，所以其长度为 1。


* 示例3：
>输入: s = "pwwkew"  
>输出: 3  
>解释: 因为无重复字符的最长子串是"wke"，所以其长度为3。 
请注意，你的答案必须是子串的长度，"pwke"是一个子序列，不是子串。

### 代码  

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Set<Character> set = new HashSet<Character>();
        int r = 0, ans = 0;
        for(int i = 0; i < len; i++) {
            if(i != 0)
                set.remove(s.charAt(i - 1));
            while(r < len && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                ++r;
            }
            ans = Math.max(ans, r - i);
        }
        return ans;
    }
}
```  
采用双指针，当从第0个字符开始，字符不在set中则加入到set，右指针右移。  
如果右侧出现相同的字符，则左指针右移一位并将相同的字符从set中移除。

<hr> 

## 15. 三数之和
### **题目**
给你一个整数数组nums，判断是否存在三元组[nums[i], nums[j], nums[k]]满足i != j、i != k、j != k，
同时还满足nums[i] + nums[j] + nums[k] == 0。请你返回所有和为0且不重复的三元组。

* 示例1：
>输入：nums = [-1,0,1,2,-1,-4]      
>输出：[[-1,-1,2],[-1,0,1]]  
>解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
* 示例2：
>输入:nums = [0,1,1]
>输出:[]
>解释:唯一可能的三元组和不为 0 。
* 示例3：
>输入：nums = [0,0,0]    
>输出：[[0,0,0]]
>解释：唯一可能的三元组和为 0 。

## 代码
```java
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1])  continue;
            int target = -nums[i];
            for (int j = i + 1; j < len; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k = len - 1;
                while (j < k && nums[j] + nums[k] > target)
                    k--;
                if (j == k)
                    break;
                if (nums[j] + nums[k] == target) {
                    List<Integer> ans = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    res.add(ans);
                }
            }
        }
        return res;
    }
}
```

<hr>

## 48. 旋转图像
### **题目**
给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

* 示例1：  
  <img src="https://s2.loli.net/2025/02/24/eFHWQO2RvoCuM9E.png" >
>输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
>输出：[[7,4,1],[8,5,2],[9,6,3]]

* 示例2：  
  <img src="https://s2.loli.net/2025/02/24/eFHWQO2RvoCuM9E.png" >
>输入: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
>输出: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
## 代码
```java  
class Solution {  
    public void rotate(int[][] matrix) {  
        int m = matrix.length, n = matrix[0].length;  
        int[] ans = new int[m * n];  
        int k = 0;  
        for (int i = m - 1; i >= 0; i--) {  
            for (int j = 0; j < n; j++) {  
                ans[k++] = matrix[i][j];  
            }  
        }  
        k = 0;  
        for (int i = 0; i < n; i++) {  
            for (int j = 0; j < m; j++) {  
                matrix[j][i] = ans[k++];  
            }  
        }  
        //1 2 3    7 4 1  
        //4 5 6    8 5 2        
        //7 8 9    9 6 3    
    }  
}
```
先将数组按照从最后一行到第一行写入数组，再将数组按照先列后行写入原数组。

<hr>

## 54. 螺旋矩阵
### **题目**
给你一个m行n列的矩阵matrix，请按照**顺时针螺旋顺序**，返回矩阵中的所有元素。

* 示例1：  
  <img src="https://s2.loli.net/2025/02/25/mbMFInQLeGkPUxK.png"  style="height: 500px; width: 500px">
>输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
>输出：[1,2,3,6,9,8,7,4,5]

* 示例2：  
  <img src="https://s2.loli.net/2025/02/25/938oRndGmCxFDvE.png"  style="height: 500px; width: 600px">
>输入: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
>输出: [1,2,3,4,8,12,11,10,9,5,6,7]
## 代码
- 按层模拟
```java  
class Solution {  
    public List<Integer> spiralOrder(int[][] matrix) {  
        List<Integer> res = new ArrayList<>();  
        int m = matrix.length, n = matrix[0].length;  
        int top = 0, left = 0;  
        int bottom = m -1, right = n - 1;  
        while (top <= bottom && left <= right) {  
            for (int j = left; j <= right; j++)  
                res.add(matrix[top][j]);  
            top++;  
            for (int i = top; i <= bottom; i++)  
                res.add(matrix[i][right]);  
            right--;  
            if (left <= right && top <= bottom) {  
                for (int j = right; j >= left; j--)  
                    res.add(matrix[bottom][j]);  
                bottom--;  
                for (int i = bottom; i >= top; i--)  
                    res.add(matrix[i][left]);  
                left++;  
            }  
        }  
        return res;  
        //1  2  3  4  
        //5  6  7  8        
        //9  10 11 12        
        //13 14 15 16    
    }  
}
```
设置四个边界top, bottom, left, right，从左到右：(top, left)到(top, right)，然后top++表示进入下一层，当前已遍历1，2，3，4；从上到下：(top, right)到(bottom, right)，然后right++，当前已遍历8，12，16；由于top和right已更新，判断是否越过边界。从右到左：(bottom, right)到(bottom, left)，然后bottom--，当前已遍历15，14，13；从下到上：(bottom, left)到(top, left)，然后left++，当前已遍历9，4。

- 模拟
```java  
class Solution {  
    public List<Integer> spiralOrder(int[][] matrix) {  
        List<Integer> res = new ArrayList<Integer>();  
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)  
            return res;  
        int m = matrix.length, n = matrix[0].length;  
        boolean[][] visited = new boolean[m][n];  
        int row = 0, col = 0;  
        int total = m * n;  
        int index = 0;  
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  
        for (int i = 0; i < total; i++) {  
            res.add(matrix[row][col]);  
            visited[row][col] = true;  
            int nextRow = row + directions[index][0], nextCol = col + directions[index][1];  
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) {  
                index = (index + 1) % 4;  
            }  
            row += directions[index][0];  
            col += directions[index][1];  
        }  
        return res;  
    }  
}
```
设定一个方向二位数组，分别表示向右，向下，向左，向上，从(0, 0)开始，逐次向右，每次计算nextRow和nextCol，判断是否越界和是否访问过，是则index++并且对4取余，然后row和col变换后进入下一次循环。

<hr>

## 66. 加一
### 题目
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。

* 示例1：
>输入：digits = [1,2,3]     
>输出：[1,2,4]  
>解释：输入数组表示数字 123。

* 示例2：
>输入：digits = [4,3,2,1]   
>输出：[4,3,2,2]
>解释：输入数组表示数字 4321。

* 示例3：
>输入：digits = [9]
>输出：[1,0]
>解释：输入数组表示数字 9。加 1 得到了 9 + 1 = 10。因此，结果应该是 [1,0]。

## 代码
```java  
public class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
```

## 73. 矩阵置零
### **题目**
给定一个 `_m_ x _n_` 的矩阵，如果一个元素为 **0** ，则将其所在行和列的所有元素都设为 **0** 。请使用原地算法。

* 示例1
  <img src="https://s2.loli.net/2025/02/24/lQtwrvN63Ds8kAJ.png" >
>输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
>输出：[[1,0,1],[0,0,0],[1,0,1]]

* 示例2  
  <img src="https://s2.loli.net/2025/02/24/kTX7a6gvs9f5RuB.png" >
>输入: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
>输出: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
## 代码
- 暴力解法：
```java  
class Solution {  
    public void setZeroes(int[][] matrix) {  
        int m = matrix.length, n = matrix[0].length;  
        int[][] ans = new int[m][n];  
        for (int i = 0; i < m; i++) {  
            for (int j = 0; j < n; j++) {  
                ans[i][j] = matrix[i][j];  
            }  
        }  
        for (int i = 0; i < m; i++) {  
            for (int j = 0; j < n; j++) {  
                if (ans[i][j] == 0) {  
                    for (int k = 0; k < m; k++) {  
                        matrix[k][j] = 0;  
                    }  
                    for (int k = 0; k < n; k++) {  
                        matrix[i][k] = 0;  
                    }  
                }  
            }  
        }  
    }  
}
```

- 使用记录数组：
```java
public class Solution {  
    public void setZeroes(int[][] matrix) {  
        int m = matrix.length, n = matrix[0].length;  
        boolean[] row = new boolean[m];  
        boolean[] col = new boolean[n];  
        for (int i = 0; i < m; i++) {  
            for (int j = 0; j < n; j++) {  
                if (matrix[i][j] == 0) {  
                    row[i] = col[j] = true;  
                }  
            }  
        }  
        for (int i = 0; i < m; i++) {  
            for (int j = 0; j < n; j++) {  
                if (row[i] || col[j]) {  
                    matrix[i][j] = 0;  
                }  
            }  
        }  
    }  
}
```

<hr>

## 73. 矩阵置零
### **题目**
给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
* 示例1
  <img src="https://s2.loli.net/2025/02/24/lQtwrvN63Ds8kAJ.png" >
>输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
>输出：[[1,0,1],[0,0,0],[1,0,1]]

* 示例2  
  <img src="https://s2.loli.net/2025/02/24/kTX7a6gvs9f5RuB.png" >
>输入: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
>输出: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
## 代码
- 暴力解法：
```java  
class Solution {  
    public void setZeroes(int[][] matrix) {  
        int m = matrix.length, n = matrix[0].length;  
        int[][] ans = new int[m][n];  
        for (int i = 0; i < m; i++) {  
            for (int j = 0; j < n; j++) {  
                ans[i][j] = matrix[i][j];  
            }  
        }  
        for (int i = 0; i < m; i++) {  
            for (int j = 0; j < n; j++) {  
                if (ans[i][j] == 0) {  
                    for (int k = 0; k < m; k++) {  
                        matrix[k][j] = 0;  
                    }  
                    for (int k = 0; k < n; k++) {  
                        matrix[i][k] = 0;  
                    }  
                }  
            }  
        }  
    }  
}
```

- 使用记录数组：
```java
public class Solution {  
    public void setZeroes(int[][] matrix) {  
        int m = matrix.length, n = matrix[0].length;  
        boolean[] row = new boolean[m];  
        boolean[] col = new boolean[n];  
        for (int i = 0; i < m; i++) {  
            for (int j = 0; j < n; j++) {  
                if (matrix[i][j] == 0) {  
                    row[i] = col[j] = true;  
                }  
            }  
        }  
        for (int i = 0; i < m; i++) {  
            for (int j = 0; j < n; j++) {  
                if (row[i] || col[j]) {  
                    matrix[i][j] = 0;  
                }  
            }  
        }  
    }  
}
```

<hr>

## 189. 轮转数组
### 题目
给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。

* 示例1：

>输入: nums = [1,2,3,4,5,6,7], k = 3  
>输出: [5,6,7,1,2,3,4]  
>解释: 向右轮转 1 步: [7,1,2,3,4,5,6]，向右轮转 2 步: [6,7,1,2,3,4,5]，向右轮转 3 步: [5,6,7,1,2,3,4]

### 代码

```java
class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        int[] nums1 = new int[length];
        for (int i = 0; i < k; i++) {
            nums1[i] = nums[length - k + i] ;
        }
        for (int j = k; j < length; j++) {
            nums1[j] = nums[j - k];
        }
        System.arraycopy(nums1, 0, nums, 0, length);
    }
}
```
记住最后将临时数组写回原数组。

<hr>

## 238. 除自身以外数组的乘积
### **题目**
给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
请 不要使用除法，且在 O(n) 时间复杂度内完成此题。

* 示例1：
>输入：nums = [1,2,3,4]
>输出：[24,12,8,6]

* 示例2：
>输入：nums = [-1,1,0,-3,3]
>输出：[0,0,9,0,0]

## 代码
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int tmp = 1;
        int[] ans = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0)
                left[i] = left[i - 1] * nums[i - 1];
            else
                left[i] = tmp;
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            if (j < nums.length - 1)
                right[j] = right[j + 1] * nums[j + 1];
            else
                right[j] = tmp;
        }
        for (int k = 0; k < nums.length; k++) {
            ans[k] = left[k] * right[k];
        }
        return ans;
    }
}
```
由于时间复杂度为O(n)，所以不能使用双重循环。
<hr>

## 485. 最大连续 1 的个数
### **题目**
给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。

* 示例1：
>输入：nums = [1,1,0,1,1,1]
>输出：3
>解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.

* 示例2：
>输入：nums = [1,0,1,1,0,1]
>输出：2

## 代码
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

## 498. 对角线遍历
### **题目**
给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。

* 示例1：  
  <a href="https://smms.app/image/qWUy9ncoXD6Qi51" target="_blank">
  <img src="https://s2.loli.net/2025/02/23/qWUy9ncoXD6Qi51.png" alt="image.png" style="width:300px; height:300px;">
  </a>

>输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
>输出：[1,2,4,7,5,3,6,8,9]
* 示例2：
>输入：mat = [[1,2],[3,4]]
>输出：[1,2,3,4]
## 代码
```java  
class Solution {  
    public int[] findDiagonalOrder(int[][] matrix) {  
        if (matrix == null || matrix.length == 0) return new int[0];  
        int m = matrix.length, n = matrix[0].length;  
        int[] result = new int[m * n];  
        int row = 0, col = 0, direction = 0;  
        int index = 0;  
        while (index < m * n) {  
            result[index++] = matrix[row][col];  
            if (direction == 0) { // Up-right direction  
                if (col == n - 1) {  
                    row++;  
                    direction = 1;  
                } else if (row == 0) {  
                    col++;  
                    direction = 1;  
                } else {  
                    row--;  
                    col++;  
                }  
            } else { // Down-left direction  
                if (row == m - 1) {  
                    col++;  
                    direction = 0;  
                } else if (col == 0) {  
                    row++;  
                    direction = 0;  
                } else {  
                    row++;  
                    col--;  
                }  
            }  
        }  
        return result;  
    }  
    //1 2  3  4  
    //5 6  7  8    
    //9 10 11 12    
    //13 14 15 16  
}
```
Up-right direction = 0为下一步向右上方，例如从1到2，此时col++。当direction=0，矩阵为3 * 3，例如从3到7，
此时col = n - 1，则row应该++。若col = n - 1，但此时direction = 1，例如从4到7，此时row++，col--。
Down-left direction = 1与上同理。

<hr>

## 724.寻找数组的中心下标
### 题目
给你一个整数数组 nums ，请计算数组的 中心下标 。
数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。

* 示例1：
>输入：nums = [1, 7, 3, 6, 5, 6]     
>输出：3
>解释：
中心下标是 3 。
左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。

* 示例2：
>输入：nums = [1, 2, 3] 
>输出：-1
>解释：数组中不存在满足此条件的中心下标。

* 示例3：
>输入：nums = [2, 1, -1]
>输出：0
>解释：
中心下标是 0 。
左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。

## 代码
```java  
class Solution {
    public int pivotIndex(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        int len = nums.length;
        int count = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                ans += nums[j];
            }
            if (count == ans)
                queue.offer(i);
            ans = 0;
            count += nums[i];
        }
        if (!queue.isEmpty())
            return queue.poll();
        else
            return -1;
    }
}
```
暴力解法

```java
public class Solution {
    public int pivotIndex(int[] nums) {
        int count = Arrays.stream(nums).sum();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * ans == count - nums[i])
                return i;
            ans += nums[i];
        }
        return -1;
    }
}
```
使用前缀和，左侧和为 sum，右侧和为 total - sum - nums[i]。
如果左侧和等于右侧和，则有 sum == total - sum - nums[i]，整理后得到 2 * sum + nums[i] == total。

