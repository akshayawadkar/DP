package com.core;

import java.util.Arrays;

class KnapsackIII{

    

    static int solve(int[] values, int[] weights, int W, int n) {

        int[][] dp = new int[n + 1][W + 1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= W; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(weights[i - 1] <= j){
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
         
        return dp[n][W];

    }

    public static void main(String[] args) {

        int[] values = {20, 5, 10, 40, 15, 25};
        int[] weight = {1, 2 ,3 ,8, 7, 4};
        int W = 10;
        System.out.println(solve(values, weight, W, values.length));

    }
}