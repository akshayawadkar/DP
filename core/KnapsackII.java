package com.core;

import java.util.Arrays;

class KnapsackII{

    static int[][] dp;

    static int solve(int[] values, int[] weights, int W, int n) {

        if (n == 0) {
            return 0;
        }

        if(dp[n][W] != -1){
            return dp[n][W];
        }

        if (weights[n - 1] <= W) {
            // include
            return dp[n][W] = Math.max(values[n - 1] + solve(values, weights, W - weights[n - 1], n - 1),
                    solve(values, weights, W, n - 1));
        } else {
            // exclude
            return dp[n][W] = solve(values, weights, W, n - 1);
        }

    }

    public static void main(String[] args) {

        int[] values = { 1, 3, 4 , 5};
        int[] weight = { 1, 4, 5, 7};
        int W = 7;
        dp = new int[weight.length + 1][W + 1];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }


        System.out.println(solve(values, weight, W, values.length));

    }
}