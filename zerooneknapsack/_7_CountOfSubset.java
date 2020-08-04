package com.zerooneknapsack;

public class _7_CountOfSubset {
    private static int solve(int[] arr, int sum, int n) {

        int[][] dp = new int[n + 1][sum + 1];

        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(arr[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }


        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1};
        int x = 1;
        System.out.println(solve(arr, x, arr.length));
    }
}
