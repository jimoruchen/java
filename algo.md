# **算法**  

<hr>  

## **1.复杂度分析**  

### **1.1.算法效率评估**  

* 时间效率：算法运行速度的快慢。
* 空间效率：算法占用内存空间的大小。

### **1.2.迭代和递归**  

#### **1.2.1.迭代**  
「迭代 iteration」是一种重复执行某个任务的控制结构。在迭代中，程序会在满足一定的条件下重复执行某
段代码，直到这个条件不再满足。

* for循环
```java
public class Main {
    public static void main(String[] args) {
        System.out.println(forloop(10));
    }
    public static int forloop(int n) {
        int res = 0;
        //循环求和1, 2, ..., n - 1, n
        for (int i = 1; i <= n; i++) {
            res += i;
        }
        return res;
    }
}
```  

* while循环
```java
public class Main {
    public static void main(String[] args) {
        System.out.println(whileloop(10));
    }
    public static int whileloop(int n) {
        int res = 0, i = 1;
        //循环求和1, 2, ..., n - 1, n
        while(i <= n) {
            res += i;
            i++;
        }
        return res;
    }
}
```  

* 嵌套循环  
```java
public class Main {
    public static void main(String[] args) {
        System.out.println(nestedForLoop(5));
    }
    public static String nestedForLoop(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                builder.append("(" + i + "," + j + "), ");
            }
        }
        return builder.toString();
    }
}
```  

#### **1.2.2.递归**  
「递归 recursion」是一种算法策略，通过函数调用自身来解决问题。它主要包含两个阶段。
1. 递：程序不断深入地调用自身，通常传入更小或更简化的参数，直到达到“终止条件”。
2. 归：触发“终止条件”后，程序从最深层的递归函数开始逐层返回，汇聚每一层的结果。

求和1 + ... + n
```java
public class Main {
    public static void main(String[] args) {
        System.out.println(recur(10));
    }
    public static int recur(int n) {
        if(n == 1)
            return 1;
        else
            return n + recur(n - 1);
    }
}
```

求斐波拉契数列第n个值
```java
public class Main {
    public static void main(String[] args) {
        System.out.println(fib(7));
    }
    public static int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }
}
```

### **1.3.时间复杂度**  
* 常数阶 𝑂(1)  

常数阶的操作数量与输入数据大小 𝑛 无关，即不随着 𝑛 的变化而变化。
```java
public class Main {
    public static void main(String[] args) {
        System.out.println(constant(10));
    }
    public static int constant(int n) {
        int count = 0;
        int size = 1000;
        for (int i = 0; i < size; i++) 
            count++;
        return count;
    }
}
```  

* 线性阶 𝑂(𝑛)

线性阶的操作数量相对于输入数据大小 𝑛 以线性级别增长，线性阶通常出现在单层循环中。
```java
public class Main {
    public static void main(String[] args) {
        System.out.println(constant(10));
    }
    public static int constant(int n) {
        int count = 0;
        for (int i = 0; i < n; i++)
            count++;
        return count;
    }
}
```  

* 平方阶 𝑂(𝑛^2)  

平方阶的操作数量相对于输入数据大小 𝑛 以平方级别增长，平方阶通常出现在嵌套循环中。

冒泡排序
```java
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++)
            nums[i] = sc.nextInt();
        int[] nums2 = bubblesort(nums);
        for (int num : nums2) {
            System.out.print(num + " ");
        }
    }
    public static int[] bubblesort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length - 1; j++) {
                if(nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
        return nums;
    }
}
```  

* 指数阶 𝑂(2^n)

生物学的“细胞分裂”是指数阶增长的典型例子：初始状态为 1 个细胞，分裂一轮后变为 2 个，分裂两轮后
变为 4 个，以此类推，分裂 𝑛 轮后有 2^𝑛 个细胞。

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(exponential(5));
    }
    public static int exponential(int n) {
        int count = 0, base = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < base; j++)
                count++;
            base *= 2;
        }
        return count;
    }
}
```

* 对数阶 𝑂(log 𝑛)  

与指数阶相反，对数阶反映了“每轮缩减到一半”的情况。设输入数据大小为 𝑛 ，由于每轮缩减到一半，因
此循环次数是 log2𝑛 ，即 2^𝑛 的反函数。  
设迭代次数为k，则2^k = n，所以k = log2n。

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(logarithmic(8));
    }
    public static int logarithmic(float n) {
        int count = 0;
        while(n > 1) {
            n /= 2;
            count++;
        }
        return count;
    }
}
```  

* 线性对数阶 𝑂(𝑛 log 𝑛)

线性对数阶常出现于嵌套循环中，两层循环的时间复杂度分别为 𝑂(log 𝑛) 和 𝑂(𝑛)。

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(linearLogRecur(8));
    }
    public static int linearLogRecur(float n) {
        if(n <= 1) return 1;
        int count = linearLogRecur(n / 2) + linearLogRecur(n / 2);
        for (int i = 0; i < n; i++) 
            count++;
        return count;
    }
}
```  

* 阶乘阶 𝑂(𝑛!)  

阶乘阶对应数学上的“全排列”问题。给定 𝑛 个互不重复的元素，求其所有可能的排列方案。

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(factorialRecur(8));
    }
    public static int factorialRecur(float n) {
        if(n == 0) return 1;
        int count = 0;
        for (int i = 0; i < n; i++)
            count += factorialRecur(n - 1);
        return count;
    }
}
```  
<hr>

## **2.数组与链表**  

### **2.1.数组**  

#### **2.1.1.数组常用操作**  

* 初始化数组  
`int[] arr = new int[5];`  
`int[] arr = {1, 2, 3, 4, 5};`  


* 插入元素  
```java
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 6};
        insert(nums, 3, 2);
        for (int i = 0; i < nums.length; i++) 
            System.out.println(nums[i]);
    }
    public static void insert(int[] nums, int num, int index) {
        for(int i = nums.length - 1; i > index; i--)
            nums[i] = nums[i - 1];
        nums[index] = num;
    }
}
```  


* 删除元素  
```java
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4};
        remove(nums, 3);
        int[] nums1 = IntStream.range(0, nums.length)
                                .limit(nums.length - 1)
                                .map(i -> nums[i])
                                .toArray();
        for (int i = 0; i < nums1.length; i++)
            System.out.println(nums[i]);
    }
    public static void remove(int[] nums, int index) {
        for(int i = index - 1; i < nums.length - 1; i++)
            nums[i] = nums[i + 1];
    }
}
```    


* 扩容数组  
```java
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = extend(nums1, 2);
        for(int num : nums2)
            System.out.println(num);
    }
    public static int[] extend(int[] nums1, int enlarge) {
        int[] nums = new int[nums1.length + enlarge];
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }
        return nums;
    }
}
```