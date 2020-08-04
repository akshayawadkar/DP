package com.zerooneknapsack;

import java.util.Arrays;

public class _2_KnapsackMemoization {

    static int[][] dp;
    private static int solve(int[] values, int[] weights, int W, int n){

        if(n == 0 || W == 0){
            return 0;
        }
        if(dp[n][W] != -1){
            return dp[n][W];
        }

        if(weights[n - 1] <= W){
            return dp[n][W] = Math.max(solve(values, weights, W, n - 1),
                    values[n - 1] + solve(values, weights, W - weights[n - 1], n - 1));
        }else{
            return dp[n][W] = solve(values, weights, W, n - 1);
        }

    }


    public static void main(String[] args) {

        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;

        dp = new int[values.length + 1][W + 1];
        for(int[] ar : dp){
            Arrays.fill(ar, - 1);
        }

        System.out.println(solve(values, weights, W, values.length));
    }
}
