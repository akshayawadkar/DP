package com.core.Unbounded

class CoinChange{

    static int solve(int[] arr, int sum, int n){
       
        int[][] dp = new int[n + 1][sum + 1];

        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                
                if(arr[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i - 1]];    
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
        

    }
    public static void main(String[] args) {
        int[] values = {1, 2, 3}; 
        int n = values.length; 
        
        int W = 5;

        System.out.println(solve(values, W, n));
    }
}