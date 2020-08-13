package com.core.Test;

//count min subset diff
public class Eight {
    
    public static int helper(int[] arr, int diff){
        int sum = 0;
        for(int i : arr){
            sum += i;
        }

        int tofind = (diff + sum) / 2;
        System.out.println(tofind);
        return solve2(arr, tofind, arr.length);
    }

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
        
        int[] arr = {1, 1, 2, 3};
        int diff = 3;

        System.out.println(helper(arr, diff));
    }
}