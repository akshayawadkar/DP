package com.core.Test;

//Equal Sum Partition Problem
public class Five {

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
        
        if(W == 0){
            return true;
        }

        if(n <= 0 || W < 0){
            return false;
        }
        
        if(values[n - 1] <= W){
            return solve(values, W - values[n - 1], n - 1) || solve(values, W, n - 1);
        }else{
            return solve(values, W, n - 1);
        }
    }
    
    public static void main(String[] args) {
        
        int[] values = {1, 2, 3, 5};
        int n = values.length;
        
        System.out.println(helper(values, n));
    }
}