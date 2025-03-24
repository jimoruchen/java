import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 3, 5};
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
