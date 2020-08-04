package com.zerooneknapsack;

import java.util.Arrays;

public class _6_EqualSumPartitionProblem {

    private static boolean subsetSum_Top_Down(int[] arr, int sum, int n) {

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for(int i = 0; i < dp.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
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
        int[] arr = {1, 5, 11, 5};
        System.out.println(solve(arr));
    }

    private static boolean solve(int[] arr) {

        int sum = Arrays.stream(arr).sum();

        if(sum % 2 != 0){
            return false;
        }

        return subsetSum_Top_Down(arr, sum / 2, arr.length);
    }

}
