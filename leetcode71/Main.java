package leetcode71;

public class Main {
    public static void main(String[] args) {
        String str = "/home/user/Documents/../Pictures";
        String[] strings = str.split("/");   //使用split方法进行字符串分割，比如这里就是通过空格分隔，得到一个字符串数组
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
