package com.core.Test;

import java.util.Arrays;

//count subsets with given sum
public class Nine {
 
    static int solve2(int[] values, int W, int n){
        int[][] dp = new int[n + 1][W + 1];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(values[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - values[i - 1]];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

 
    public static void main(String[] args) {
        
        int[] arr = {3, 3, 3, 3};
        int sum = 6;
        System.out.println(solve2(arr, sum, arr.length));
    }
}