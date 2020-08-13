package com.core.LCS
// LCS using recursion

import java.util.Arrays;

class Two{


    static int[][] dp;

    static int solve(String X, String Y, int m, int n){
        if(m == 0 || n == 0){
            return 0;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        if(X.charAt(m - 1) == Y.charAt(n - 1)){
            return  dp[m][n] = 1 + solve(X, Y, m - 1, n - 1);
        }else{
            return dp[m][n] = Math.max(solve(X, Y, m - 1, n),  solve(X, Y, m, n - 1));
        }
    }


    public static void main(String[] args) {
        String X = "abcdgh";
        String Y = "abedfhr";
        dp = new int[X.length() + 1][Y.length() + 1];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        System.out.println(solve(X, Y, X.length(), Y.length()));
    }
}