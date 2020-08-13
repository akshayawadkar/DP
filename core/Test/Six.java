package com.core.Test;

// Equal sum partion using top down;
public class Six {
   
    public static boolean helper(int[] values, int n){
    
    int sum = 0;
    for(int i : values){
        sum += i;
    }

    System.out.println(sum);
    if(sum % 2 != 0){
        return false;
    }
    return solve(values, sum / 2, n);
}


public static boolean solve(int[] values, int W, int n){
  
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
        int[] values = {1, 2, 3, 5};
        int n = values.length;
        
        System.out.println(helper(values, n));
    }
}