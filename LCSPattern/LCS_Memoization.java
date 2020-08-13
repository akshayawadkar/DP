package com.LCSPattern;

import java.util.Arrays;

public class LCS_Memoization {
    static int[][] dp;
    private static int solve(String X, String Y){
        dp = new int[X.length() + 1][Y.length() + 1];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }

        int result = helper(X, Y, X.length(), Y.length());
        return result;
    }

    private static int helper(String X, String Y, int m, int n){

        if(m == 0 || n == 0){
            return 0;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }


        if(X.charAt(m - 1) == Y.charAt(n - 1)){
            return dp[m][n] = 1 + helper(X, Y, m - 1, n - 1);
        }else{
            return dp[m][n] = Math.max(helper(X, Y, m - 1, n),
                            helper(X, Y, m, n - 1));
        }
    }

    public static void main(String[] args) {
        String X = "abcdgh";
        String Y = "abedfhr";
        System.out.println(solve(X, Y));
    }
}
