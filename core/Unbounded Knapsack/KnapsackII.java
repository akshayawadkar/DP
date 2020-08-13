package com.core.Unbounded

import java.util.Arrays;

class KnapsackII{


    static int[][] dp;
    static int solve(int[] values, int[] weights, int W, int n){
        if(n == 0){
            return 0;
        }
        if(dp[n][W] != -1){
            return dp[n][W];
        }

        if(weights[n - 1] <= W){
            return dp[n][W] = Math.max(values[n - 1] + solve(values, weights, W - weights[n - 1], n), solve(values, weights, W, n - 1));
        }else{
            return dp[n][W] = solve(values, weights, W, n - 1);
        }
    }


    public static void main(String[] args) {
        int W = 100; 
        int val[] = {10, 30, 20}; 
        int wt[] = {5, 10, 15}; 
        int n = val.length;
        dp = new int[n + 1][W + 1];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        System.out.println(solve(val, wt, W, n));
    }

}