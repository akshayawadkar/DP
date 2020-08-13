package com.core.Test;

//Subsetsum Problem
public class Four {

    static boolean solve(int[] values, int W, int n){
        
        if(W == 0){
            return true;
        }
        
        if(n == 0 || W < 0){
            return false;
        }

        if(values[n - 1] <= W){
            return solve(values, W - values[n - 1], n - 1) || solve(values, W , n - 1);
        }else{
            return solve(values, W, n - 1);
        }


    }
    static boolean solve2(int[] values, int W, int n){
        boolean[][] dp = new boolean[n + 1][W + 1];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(values[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - values[i - 1]];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }


 
    
    public static void main(String[] args) {
        
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 38;
        int n = set.length;
        System.out.println(solve(set, sum, n));
        System.out.println(solve2(set, sum, n));
        
    }
}