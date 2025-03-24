package leetcode506;

import java.util.Arrays;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] str = new String[score.length];
        int[] rank = new int[score.length];
        System.arraycopy(score, 0, rank, 0, score.length);
        int tmp = 1;
        Arrays.sort(rank);
        for (int i = rank.length - 1; i >= 0; i--) {
            for (int j = 0; j < score.length; j++) {
                if (rank[i] == score[j] && tmp == 1) {
                    str[j] = "Gold Medal";
                    tmp++;
                } else if (rank[i] == score[j] && tmp == 2) {
                    str[j] = "Silver Medal";
                    tmp++;
                } else if (rank[i] == score[j] && tmp == 3) {
                    str[j] = "Bronze Medal";
                    tmp++;
                } else if (rank[i] == score[j]) {
                    str[j] = String.valueOf(rank.length - i);
                    tmp++;
                }
            }
        }
        return str;
    }
}
