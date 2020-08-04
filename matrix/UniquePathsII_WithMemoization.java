package com.matrix;

import java.util.Arrays;

public class UniquePathsII_WithMemoization {

    int[][] dp;
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m + 1][n + 1];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        return helper(grid, m - 1, n - 1);
    }

    private int helper(int[][] grid, int m, int n){


        if(m < 0 || n < 0 ){
            return 0;
        }

        if(grid[m][n] == 1){
            return 0;
        }

        if(m == 0 && n == 0){
            return 1;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        return dp[m][n] = helper(grid, m - 1, n) + helper(grid, m, n - 1);
    }
}
