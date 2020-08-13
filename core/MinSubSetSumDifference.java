package com.core;

import java.util.Arrays;

class MinSubSetSumDifference{

    public static void main(String[] args) {
        
        int[] arr = {1, 2, 7};
        System.out.println(solve(arr));
    }

    static int solve(int[] arr){

        int range = 0;
        for(int i : arr){
            range += i;
        }

        boolean[] lastRow = findLastRow(arr, range);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < lastRow.length; i++){
            if(lastRow[i] == true){
                min = Math.min(min, Math.abs(range - (2 * i)));
            }
        }
         
        return min;
    }

    static boolean[] findLastRow(int[] arr, int range){

        boolean[][] dp = new boolean[arr.length + 1][range + 1];

        for(int i = 0; i <= arr.length; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i <= arr.length; i++){
            for(int j = 1; j <= range; j++){
                if(arr[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[arr.length];
    }

}