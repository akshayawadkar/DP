package com.core.Unbounded

class KnapsackI{

    static int solve(int[] values, int[] weights, int W, int n){
        if(n == 0){
            return 0;
        }

        if(weights[n - 1] <= W){
            return Math.max(values[n - 1] + solve(values, weights, W - weights[n - 1], n), solve(values, weights, W, n - 1));
        }else{
            return solve(values, weights, W, n - 1);
        }
    }


    public static void main(String[] args) {
        int W = 100; 
        int val[] = {10, 30, 20}; 
        int wt[] = {5, 10, 15}; 
        int n = val.length;
        System.out.println(solve(val, wt, W, n));
    }

}