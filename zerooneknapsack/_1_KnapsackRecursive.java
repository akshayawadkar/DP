package com.zerooneknapsack;
public class _1_KnapsackRecursive {

    private static int solve(int[] values, int[] weights, int W, int n){

        if(n == 0 || W == 0){
            return 0;
        }

        if(weights[n - 1] <= W){
            return Math.max(solve(values, weights, W, n - 1),
                            values[n - 1] + solve(values, weights, W - weights[n - 1], n - 1));
        }else{
            return solve(values, weights, W, n - 1);
        }

    }

    public static void main(String[] args) {

        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;

        System.out.println(solve(values, weights, W, values.length));
    }
}
