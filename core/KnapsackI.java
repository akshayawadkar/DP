package com.core;

class KnapsackI{

    static int solve(int[] values, int[] weights, int W, int n){

        if(n == 0){
            return 0;
        }

        if(weights[n - 1] <= W){
            //include
            return Math.max(values[n - 1] + solve(values, weights, W - weights[n - 1], n - 1),
                             solve(values, weights, W, n - 1));
        }else{
            //exclude
            return solve(values, weights, W, n - 1);
        }


    }


    public static void main(String[] args) {
        
        int[] values = {20, 5, 10, 40, 15, 25};
        int[] weight = {1, 2 ,3 ,8, 7, 4};
        int W = 10;

        System.out.println(solve(values, weight, W, values.length));

    }
}