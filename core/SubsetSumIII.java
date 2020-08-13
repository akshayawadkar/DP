package com.core;

import java.util.*;

class SubSetSumIII{

    static boolean isSubset(int[] arr, int sum, int n){
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for(int i = 0; i < dp.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                
                if(arr[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];    
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
     


    public static void main(String[] args) {
        
        int[] arr = {7, 3, 2, 5 ,8};
        int sum = 29;
        int n = arr.length;
        
        System.out.println(isSubset(arr, sum, n));
    }
}