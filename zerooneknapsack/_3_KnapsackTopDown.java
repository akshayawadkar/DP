package com.zerooneknapsack;

import java.util.Arrays;

public class _3_KnapsackTopDown {


    private static int solve(int[] values, int[] weights, int W, int n){

        int[][] dp = new int[n + 1][W + 1];

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp.length; j++){

                if(weights[i - 1] <= j){
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }


    public static void main(String[] args) {

        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;

        System.out.println(solve(values, weights, W, values.length));
    }
}
