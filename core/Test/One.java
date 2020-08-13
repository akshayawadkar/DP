package com.core.Test;

//0 - 1 Knapsack Recursive
class One{

    static int solve(int[] values, int[] weights, int W, int n){
        
        if(n == 0){
            return 0;
        }
        if(weights[n - 1] <= W){
            return Math.max(values[n - 1] + solve(values, weights, W - weights[n - 1], n - 1), solve(values, weights, W, n - 1));
        }else{
            return solve(values, weights, W, n - 1);
        }
    }

    public static void main(String[] args) {
        
        int[] values = {60, 100, 120};
        int[] weights = {10 ,20, 30};
        int W = 50;
        int n = values.length;
        System.out.println(solve(values, weights, W, n));


    }

}