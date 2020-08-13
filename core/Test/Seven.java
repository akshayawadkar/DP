package com.core.Test;

import java.util.Arrays;

//minimum subset sum difference
public class Seven {
    

    static int solve(int[] arr){

        int n = arr.length;
        int sum  = 0;
        for(int i : arr){
            sum += i;
        }

        boolean[] last_row = solve(arr, sum, n);
        System.out.println(Arrays.toString(last_row));
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < last_row.length / 2; i++){
            if(last_row[i]  == true){
                min = Math.min(min, Math.abs(sum - 2 * i));
            }
        }

        return min; 
    }


    static boolean[] solve(int[] values, int W, int n){
        
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
        return dp[dp.length - 1];
    }
 


    public static void main(String[] args) {
        
        int[] arr = {1, 2, 7};
        System.out.println(solve(arr));
    }
}