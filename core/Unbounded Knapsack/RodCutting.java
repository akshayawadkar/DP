package com.core.Unbounded

import java.util.Arrays;

class RodCutting{


    static int solve(int[] values, int[] weights, int W, int n){
        if(n == 0){
            return 0;
        }

        if(weights[n - 1] <= W){
            return Math.max(values[n - 1] + solve(values, weights, W - weights[n - 1], n), solve(values, weights, W, n - 1));
        }else{
            return solve(values, weights, W, n - 1);
        }
    }


    static int[][] dp = new int[1000][1000];
    static int solveII(int[] values, int[] weights, int W, int n){
        
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

    static int solveIII(int[] values, int[] weights, int W, int n){
        int[][] dp = new int[n + 1][W + 1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(weights[i - 1] <= j){
                    dp[i][j] = Math.max(values[i - 1] + dp[i][j - weights[i - 1]], dp[i - 1][j]); 
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }
    public static void main(String[] args) {
        
        int[] values = {1, 5, 8, 9, 10, 17, 17, 20}; 
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8};

        int W = weights.length;
        int n = weights.length;

        System.out.println(solve(values, weights, W, n));
        W = weights.length;
        n = weights.length;
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        System.out.println(solveII(values, weights, W, n));

        System.out.println(solveII(values, weights, W, n));
        
    }
}