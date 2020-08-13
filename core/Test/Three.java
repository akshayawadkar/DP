package com.core.Test;

import java.util.Arrays;

//0 - 1 Knapsack Memoization or Bottom Up
class Three{

    static int solve(int[] values, int[] weights, int W, int n){
        
        int[][] dp = new int[n + 1][W + 1];

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(weights[i - 1] <= j){
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        
        int[] values = {60, 100, 120};
        int[] weights = {10 ,20, 30};
        int W = 50;
        int n = values.length;
        System.out.println(solve(values, weights, W, n));


    }

}