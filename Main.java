public class Main {
    public static void main(String[] args) {
        String str = "Hello World";
        char[] chars = str.toCharArray();
        System.out.println(chars);
        String str1 = new String(chars);
        System.out.println(str1);
    }
}
