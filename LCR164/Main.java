package LCR164;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] password = {0, 3, 30, 34, 5, 9};
        String result = solution.crackPassword(password);
        System.out.println(result);
    }
}
