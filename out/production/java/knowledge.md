## 1.使用 Collections.sort() 方法
Collections.sort() 是一个静态方法，用于对实现了 List 接口并且其元素类型实现了 Comparable 接口的列表进行排序。
```java
public class SortExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(1);
        numbers.add(4);
        
        Collections.sort(numbers);
        System.out.println(numbers); // 输出: [1, 4, 5, 9]
    }
}

```

## 2.使用 List.sort() 方法
从Java 8开始，List接口直接提供了sort()方法，它同样要求列表中的元素是可比较的（实现Comparable接口），或者在调用时提供一个自定义的比较器（实现Comparator接口）。
```java
public class SortExample {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Alice", 30));
        list.add(new Person("Bob", 25));

        list.sort(Comparator.comparing(Person::getAge));
        System.out.println(list); // 按年龄升序输出Person对象
    }
}
```

## 3.使用数组创建List列表
`Integer[] numbers = {1, 2, 3};`
`List<Integer> list = Arrays.asList(numbers);`


## 4.Integer自动装箱时IntegerCache会默认缓存-128~127之间的所有值，将这些值提前做成包装类放在数组中存放
```java
public class Test {
    public static void main(String[] args) {
        Integer a = 10, b = 10;
        System.out.println(a == b);    //输出为true
    }
}
```
