package leetcode03;

import java.util.HashSet;
import java.util.Set;

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