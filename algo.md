# **算法**  

<hr>  

## **1.复杂度分析**  

### **1.1 算法效率评估**  

* 时间效率：算法运行速度的快慢。
* 空间效率：算法占用内存空间的大小。

### **1.2 迭代和递归**  

#### **1.2.1 迭代**  
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

#### **1.2.2 递归**  
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

### **1.3 时间复杂度**  
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

### **2.1 数组**  

#### **2.1.1 数组常用操作**  

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

<hr>

### **2.2 链表**

#### **2.2.1 链表节点类**  

```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x;}
}
```

#### **2.2.2 链表常用操作**

* 初始化链表
```java
public class Main {
    public static void main(String[] args) {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(n1.next.val);
    }
}
```

* 插入节点

<img src="https://s2.loli.net/2024/07/30/AJqmxkGyMhs6IcO.png" alt="">

```java
public class Main {
    public static void main(String[] args) {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        insert(n1, 9);
        System.out.println(n1.next.val);
    }
    static void insert(ListNode n1, int val) {
        ListNode p = new ListNode(val);
        p.next = n1.next;
        n1.next = p;
    }
}
```  

* 删除节点  

<img src="https://s2.loli.net/2024/07/31/AdsV8Qw1xzayJWl.png" alt="">

```java
public class Main {
    public static void main(String[] args) {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        remove(n1);
        System.out.println(n1.next.val);
    }
    static void remove(ListNode n1) {
        if(n1.next == null) return;
        n1.next = n1.next.next;
    }
}
```  

* 访问节点

```java
public class Main {
    public static void main(String[] args) {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode p = access(n0, 3);
        if (p != null) {
            System.out.println(p.val);
        }
    }
    static ListNode access(ListNode head, int n) {
        for (int i = 0; i < n; i++) {
            if (head == null)
                return null;
            head = head.next;
        }
        return head;
    }
}
```  

* 查找节点  

```java
public class Main {
    public static void main(String[] args) {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(find(n0, 3));
    }
    static int find(ListNode head, int target) {
        int index = 0;
        while (head != null) {
            if(head.val == target)
                return index;
            head = head.next;
            index++;
        }
        return -1;
    }
}
```

<hr>

### **2.3 列表** 

#### **2.3.1 列表常用操作**

* 初始化列表
```java
public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Integer[] numbers = new Integer[] {1, 2, 3, 4, 5};
        List<Integer> nums1 = new ArrayList<>(Arrays.asList(numbers));
        System.out.println(nums1.get(0));
    }
}
```

* 访问元素  
```java
public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(111);
        nums.add(222);
        nums.set(1, 333);
        System.out.println(nums.get(1));
    }
}
```  

* 插入与删除元素  
```java
public class Main {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[] {1, 2};
        List<Integer> nums = new ArrayList<>(Arrays.asList(numbers));
        nums.clear();
        nums.add(1);
        nums.add(2);
        nums.add(4);
        nums.add(2, 3);
        System.out.println(nums.get(2));    // 3
        nums.remove(2);
        System.out.println(nums.get(2));    // 4
    }
}
```  

* 遍历列表  
```java
public class Main {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[] {1, 2, 3, 4, 5};
        List<Integer> nums = new ArrayList<>(Arrays.asList(numbers));
        for (int i = 0; i < nums.size(); i++) 
            System.out.print(nums.get(i) + " ");
        System.out.println();
        for (int num: nums) 
            System.out.print(num + " ");
    }
}
```  

* 拼接列表  
```java
public class Main {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[] {1, 2, 3, 4, 5};
        List<Integer> nums = new ArrayList<>(Arrays.asList(numbers));
        List<Integer> nums1 = new ArrayList<>(Arrays.asList(6, 7, 8, 9, 10));
        nums.addAll(nums1);
        for (int num : nums)
            System.out.println(num);
    }
}
```  

* 排序列表  
```java
public class Main {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[] {2, 1, 3, 4, 5};
        List<Integer> nums = new ArrayList<>(Arrays.asList(numbers));
        Collections.sort(nums);
        for (int num : nums)
            System.out.println(num);
    }
}
```  

<hr>

#### **2.3.2 列表实现**  
```java
public class MyList {
    private int[] arr;
    private int capacity = 10;
    private int size = 0;
    private int extendRatio = 2;

    public MyList() {
        arr = new int[capacity];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public void extendRatio() {
        arr = Arrays.copyOf(arr, capacity() * extendRatio);
        capacity = arr.length;
    }
    public int get(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("索引越界");
        return arr[index];
    }

    public void set(int index, int num) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("索引越界");
        arr[index] = num;
    }

    public void add(int num) {
        if(size == capacity())
            extendRatio();
        arr[size] = num;
        size++;
    }

    public int remove(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("索引越界");
        int num = arr[index];
        for(int i = index; i < size - 1; i++)
            arr[i] = arr[i + 1];
        size--;
        return num;
    }

    public void insert(int index, int num) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("索引越界");
        if(size == capacity())
            extendRatio();
        for(int j = size - 1; j >= index; j--)
            arr[j + 1] = arr[j];
        arr[index] = num;
        size++;
    }

    public int[] toArray() {
        int size = size();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = get(i);
        return arr;
    }
}
```  

<hr>

## **3.栈与队列** 

### **3.1 栈**  

#### **3.1.1 栈的常用操作**  
```java
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
    }
}
```  

#### **3.1.2 栈的实现**

* 基于数组的实现
```java
public class ArrayStack {
    private ArrayList<Integer> stack;

    public ArrayStack() {
        stack = new ArrayList<>();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(int value) {
        stack.add(value);
    }

    public int peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return stack.get(size() - 1);
    }

    public int pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        return stack.remove(size() - 1);
    }

    public Object[] toArray() {
        return stack.toArray();
    }
}
```  

* 基于链表实现  
```java
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
```

<hr>  

### **3.2 队列**  

#### **3.2.1 队列常用操作**  
```java
public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
    }
}
```  

#### **3.2.2 队列实现**

* 基于链表的实现
```java
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
```  

### **3.3双向队列**  

#### **3.3.1双向队列常用操作**  
```java
public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<Integer>();
        deque.offerLast(3);
        deque.offerLast(4);
        deque.offerLast(5);
        deque.offerFirst(2);
        deque.offerFirst(1);
        System.out.println(deque.size());
        System.out.println(deque.isEmpty());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
    }
}
```  

<hr>

## **4.哈希表**  

### **4.1 哈希表**  
「哈希表 hash table」，又称「散列表」，它通过建立键 key 与值 value 之间的映射，实现高效的元素查询。具体而言，我们向哈希表中输入一个键 key ，则可以在 𝑂(1) 时间内获取对应的值 value 。
<img src="https://s2.loli.net/2024/08/07/nxkdEapPNSsblF6.png">

#### **4.1.1 哈希表常用操作**  
```java
public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "AAA");
        map.put(2, "BBB");
        map.put(3, "CCC");
        map.put(4, "DDD");
        String str = map.get(1);
        map.remove(4);
        boolean b = map.containsKey(3);
        for (Map.Entry<Integer, String> kv : map.entrySet())
            System.out.println(kv.getKey() + ", " + kv.getValue());
        for (int key : map.keySet())
            System.out.println(key);
        for (String value : map.values())
            System.out.println(value);
    }
}
```

#### **4.1.2 哈希冲突与扩容**

* 链式地址
```java
public class Pair {
    public int key;
    public String val;
    public Pair(int key, String val) {
        this.key = key;
        this.val = val;
    }
}

public class HashMapChaining {
    int size;
    int capacity;
    double loadThres;
    int extendRatio;
    List<List<Pair>> buckets;

    public HashMapChaining() {
        size = 0;
        capacity = 4;
        loadThres = 2.0 / 3.0;
        extendRatio = 2;
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++)
            buckets.add(new ArrayList<>());
    }

    int hashFunc(int key) {
        return key % capacity;
    }

    double loadFactor() {
        return (double) size / capacity;
    }

    String get(int key) {
        int index = hashFunc(key);
        List<Pair> bucket = buckets.get(index);
        for (Pair pair : bucket) {
            if (pair.key == index)
                return pair.val;
        }
        return null;
    }

    void put(int key, String val) {
        if (loadFactor() > loadThres)
            extend();
        int index = hashFunc(key);
        List<Pair> bucket = buckets.get(index);
        for (Pair pair : bucket) {
            if (pair.key == key) {
                pair.val = val;
                return;
            }
        }
        Pair pair = new Pair(key, val);
        bucket.add(pair);
        size++;
    }

    void remove(int key) {
        int index = hashFunc(key);
        List<Pair> bucket = buckets.get(index);
        for (Pair pair : bucket) {
            if (pair.key == key) {
                bucket.remove(pair);
                size--;
                break;
            }
        }
    }

    void extend() {
        List<List<Pair>> bucketsTmp = buckets;
        capacity *= extendRatio;
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++)
            buckets.add(new ArrayList<>());
        size = 0;
        for (List<Pair> bucket : bucketsTmp) {
            for (Pair pair : bucket)
                put(pair.key, pair.val);
        }
    }

    void print() {
        for (List<Pair> bucket : buckets) {
            List<String> res = new ArrayList<>();
            for (Pair pair : bucket)
                res.add(pair.val + "->" + pair.val);
            System.out.println(res);
        }
    }
}
```

<hr>

## **5.树**

### **5.1 二叉树**
```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {val = x;}
}
```
#### **5.1.1二叉树基本操作**
* 初始化二叉树
```java
public class Main {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        System.out.println(n1.left.left.val);       // 4
    }
}
```

* 插入与删除节点
```java
public class Main {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        System.out.println(n1.left.left.val);       // 4
        TreeNode p = new TreeNode(6);
        n1.left = p;
        p.left = n2;
        System.out.println(n1.left.left.val);       // 2
        n1.left = n2;
        System.out.println(n1.left.left.val);       // 4
    }
}
```

#### **5.1.2 常见二叉树类型**
* 完美二叉树
<img src="https://s2.loli.net/2024/08/30/uP182DW6ieFAxnw.png" >

* 完全二叉树
只有最底层的节点未被填满，且最底层节点尽量靠左填充。
<img src="https://s2.loli.net/2024/08/30/oD7fKkUhHsbugdF.png" >

* 完满二叉树
除了叶节点之外，其余所有节点都有两个子节点
<img src="https://s2.loli.net/2024/08/30/VyHCgn6vSN9lbBp.png" >

* 平衡二叉树
任意节点的左子树和右子树的高度之差的绝对值不超过1。
<img src="https://s2.loli.net/2024/08/30/VyHCgn6vSN9lbBp.png" >


### 5.2二叉树遍历

#### 5.2.1 层序遍历
```java
public class Main {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        List<Integer> nums = levelOrder(n1);
        for (int num : nums)
            System.out.println(num);
    }

    public static List<Integer> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return list;
    }
}
```

#### 5.2.2 前序、中序、后序遍历
```java
public class Main {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        System.out.println("先序遍历:");
        for (int num : preOrder(n1, list1))
            System.out.print(num + " ");
        System.out.println();
        System.out.println("中序遍历:");
        for (int num : inOrder(n1, list2))
            System.out.print(num + " ");
        System.out.println();
        System.out.println("后序遍历:");
        for (int num : postOrder(n1, list3))
            System.out.print(num + " ");
    }
    public static List<Integer> preOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return null;
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
        return list;
    }
    public static List<Integer> inOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return null;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
        return list;
    }
    public static List<Integer> postOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return null;
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
        return list;
    }
}
```

### 5.3二叉搜索树
1. 对于根节点，左子树中所有节点的值 < 根节点的值 < 右子树中所有节点的值。
2. 任意节点的左、右子树也是二叉搜索树，即同样满足条件1。  
<img src="https://s2.loli.net/2024/09/01/ZIsemwi5vatWM4C.png" >  

#### 5.3.1 二叉搜索树的操作
* 查找节点
```java
public class Main {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(12);
        TreeNode n13 = new TreeNode(13);
        TreeNode n14 = new TreeNode(14);
        TreeNode n15 = new TreeNode(15);
        n8.left = n4;
        n8.right = n12;
        n4.left = n2;
        n4.right = n6;
        n12.left = n10;
        n12.right = n14;
        n2.left = n1;
        n2.right = n3;
        n6.left = n5;
        n6.right = n7;
        n10.left = n9;
        n10.right = n11;
        n14.left = n13;
        n14.right = n15;
        List<Integer> list = levelOrder(n8);
        for (Integer num : list)
            System.out.print(num + " ");        // 8 4 12 2 6 10 14 1 3 5 7 9 11 13 15
        TreeNode node = search(1, n8);
        System.out.println(node.val);           // 1
    }
    
    public static TreeNode search(int num, TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (num < cur.val)
                cur = cur.left;
            else if (num > cur.val)
                cur = cur.right;
            else break;
        }
        return cur;
    }

    public static List<Integer> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return list;
    }
}
```

* 插入节点 
```java
public class Main {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(12);
        TreeNode n13 = new TreeNode(13);
        TreeNode n14 = new TreeNode(14);
        TreeNode n15 = new TreeNode(15);
        n8.left = n4;
        n8.right = n12;
        n4.left = n2;
        n4.right = n6;
        n12.left = n10;
        n12.right = n14;
        n2.left = n1;
        n2.right = n3;
        n6.left = n5;
        n6.right = n7;
        n10.left = n9;
        n10.right = n11;
        n14.left = n13;
        n14.right = n15;
        insert(-1, n8); 
        System.out.println(n1.left.val);        // -1
        List<Integer> list = levelOrder(n8);
        for (Integer num : list)
            System.out.print(num + " ");        // 8 4 12 2 6 10 14 1 3 5 7 9 11 13 15 -1 
    }

    public static void insert(int num, TreeNode root) {
        if (root == null) {
            root = new TreeNode(num);
            return;
        }
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.val == num)
                return;
            pre = cur;
            if (num < cur.val)
                cur = cur.left;
            else
                cur = cur.right;
        }
        TreeNode node = new TreeNode(num);
        if (num > pre.val)
            pre.right = node;
        else
            pre.left = node;
    }

    public static List<Integer> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return list;
    }
}
```

* 删除节点
```java
public class Main {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(12);
        TreeNode n13 = new TreeNode(13);
        TreeNode n14 = new TreeNode(14);
        TreeNode n15 = new TreeNode(15);
        n8.left = n4;
        n8.right = n12;
        n4.left = n2;
        n4.right = n6;
        n12.left = n10;
        n12.right = n14;
        n2.left = n1;
        n2.right = n3;
        n6.left = n5;
        n6.right = n7;
        n10.left = n9;
        n10.right = n11;
        n14.left = n13;
        n14.right = n15;
        remove(6, n8);
        List<Integer> list = levelOrder(n8);
        for (Integer num : list)
            System.out.print(num + " ");        // 8 4 12 2 7 10 14 1 3 5 9 11 13 15 
    }

    public static void remove(int num, TreeNode root) {
        if (root == null) return;
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (num == cur.val)
                break;
            pre = cur;
            if (num > cur.val)
                cur = cur.right;
            else
                cur = cur.left;
        }
        if (cur == null)
            return;
        if (cur.left == null || cur.right == null) {
            TreeNode child = cur.left != null ? cur.left : cur.right;
            if (cur != root) {
                if (pre.left == cur)
                    pre.left = child;
                else
                    pre.right = child;
            } else {
                root = child;
            }
        } else {
            TreeNode tmp = cur.right;
            while (tmp.left != null)
                tmp = tmp.left;
            remove(tmp.val, root);
            cur.val = tmp.val;
        }

    }

    public static List<Integer> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return list;
    }
}
```