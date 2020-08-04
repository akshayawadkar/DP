package com.matrix;

import java.util.Arrays;

public class UniquePathsI_WithMemoization {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m + 1][n + 1];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        return helper(m, n);
    }

    private int helper(int m, int n){

        if(m == 1 || n == 1){
            return 1;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }

        return dp[m][n] = helper(m - 1, n) + helper(m, n - 1);

    }

}
