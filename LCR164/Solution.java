package LCR164;

import java.util.Arrays;

class Solution {
    public String crackPassword(int[] password) {
        String[] str = new String[password.length];
        for (int i = 0; i < password.length; i++) {
            str[i] = String.valueOf(password[i]);
        }
        Arrays.sort(str, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            builder.append(str[i]);
        }
        return builder.toString();
    }
}
