## 1.排序
* 使用 Arrays.Sort() 方法
用于对数组进行排序，支持基本数据类型和对象类型的数组，但对于基本数据类型数组（如 int[]）不支持使用自定义比较器。
```java
public class Test {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        Arrays.Sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
```

```java
public class Test {
    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6,7,8,9,10};
        //Arrays.Sort(nums, (x, y) -> y - x);           //从大到小
        //Arrays.Sort(nums, (x, y) -> y.compareTo(x));
        Arrays.Sort(nums, Comparator.reverseOrder());
        System.out.println(Arrays.toString(nums));
    }
}
```

* 使用 Collections.Sort() 方法
Collections.Sort() 是一个静态方法，用于对实现了 List 接口并且其元素类型实现了 Comparable 接口的列表进行排序。
```java
public class SortExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(1);
        numbers.add(4);
        
        Collections.Sort(numbers);
        System.out.println(numbers); // 输出: [1, 4, 5, 9]
    }
}

```

* 使用 List.Sort() 方法
从Java 8开始，List接口直接提供了sort()方法，它同样要求列表中的元素是可比较的（实现Comparable接口），或者在调用时提供一个自定义的比较器（实现Comparator接口）。
```java
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        //list.Sort((x, y) -> y - x);
        //list.Sort((x, y) ->  y.compareTo(x));
        list.Sort(Comparator.reverseOrder());
        System.out.println(list);
    }
}
```

```java
public class SortExample {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Alice", 30));
        list.add(new Person("Bob", 25));
        list.Sort(Comparator.comparing(Person::getAge));
        System.out.println(list); // 按年龄升序输出Person对象
    }
}
```

* 冒泡排序
```java
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

* 快速排序
```java
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {6, 7, 5, 4, 8, 9, 1, 2, 12, 23, 3};
        System.out.println("原始数组:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        quicksort(arr, 0, arr.length - 1);
        System.out.println("\n排序后的数组:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void quicksort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            quicksort(arr, left, partition);
            quicksort(arr, partition +1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int privot = arr[left];
        int l = left - 1;
        int r = right + 1;
        while (l < r) {
            do l++; while (arr[l] < privot);
            do r--; while (arr[r] > privot);
            if (l <r) {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
            }
        }
        return r;
    }
}
```

* 三路快排
```java
public class ThreeWayQuickSort {
    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 3, 5};
        int len = nums.length;
        threeWayQuickSort(nums, 0, len - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void threeWayQuickSort(int[] nums, int left, int right) {
        if (nums == null || left < 0 || right > nums.length || left > right) {
            return;
        }
        int privot = nums[left];
        int low = left;
        int high = right;
        int i = low + 1;
        while (i <= high) {
            if (nums[i] < privot) {
                swap(nums, i++, low++);
            } else if (nums[i] > privot) {
                swap(nums, i, high--);
            } else {
                i++;
            }
        }
        threeWayQuickSort(nums, left, low - 1);
        threeWayQuickSort(nums, high + 1, right);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

## 2.使用数组创建List列表
`Integer[] numbers = {1, 2, 3};`
`List<Integer> list = Arrays.asList(numbers);`


## 3.Integer自动装箱时IntegerCache会默认缓存-128~127之间的所有值，将这些值提前做成包装类放在数组中存放
```java
public class Test {
    public static void main(String[] args) {
        Integer a = 10, b = 10;
        System.out.println(a == b);    //输出为true
    }
}
```

## 4.常用方法
* charAt(i)读取字符串第i个元素
`for (int i = 0; i < numStr.length(); i++) 
     result[i] = numStr.charAt(i) - '0';`  

* 对数组求和
```java
int count = Arrays.stream(nums).sum();
```

* 将数字数组转为数字
```java
public class Test {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int num = 0;
        for (int j : nums)
            num = num * 10 + j;
        System.out.println(num);
    }
}
```

* 将数字字符串转为整型
```java
public class Test {
    public static void main(String[] args) {
        String s1 = "111";
        //Integer i = new Integer(s1);  //弃用
        Integer i1 = Integer.valueOf(s1);
        Integer i2 = Integer.parseInt(s1);
        int i3 = i1.intValue();  //转为int
        System.out.println(i3);
    }
}
```

* 将整型转为字符串
```java
public class Test {
    public static void main(String[] args) {
        int num = 111;
        String s = String.valueOf(num);
        String s1 = Integer.toString(num);
        System.out.println(s1.getClass().getName());
    }
}
```

* 比较两个字符串的内容使用equals方法
```java
public class Main {
    public static void main(String[] args) {
        String str1 = new String("Hello World");
        String str2 = new String("Hello World");
        System.out.println(str1.equals(str2));   //字符串的内容比较，一定要用equals
    }
}
```

* 裁剪字符串
```java
public class Main {
    public static void main(String[] args) {
        String str = "Hello World";
        String sub = str.substring(0, 3);   //分割字符串，并返回一个新的子串对象
        System.out.println(sub);        //Hel
    }
}
```

* 分割字符串
```java
public class Main {
    public static void main(String[] args) {
        String str = "Hello World";
        String[] strings = str.split(" ");   //使用split方法进行字符串分割，比如这里就是通过空格分隔，得到一个字符串数组
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
```

* 字符串与字符数组相互转换
```java
public class Main {
    public static void main(String[] args) {
        String str = "Hello World";
        char[] chars = str.toCharArray();
        System.out.println(chars);
        String str1 = new String(chars);
        System.out.println(str1);
    }
}
```
