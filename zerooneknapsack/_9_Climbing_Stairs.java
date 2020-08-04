package com.zerooneknapsack;

public class _9_Climbing_Stairs {

    public static void main(String[] args) {

        int n = 3;
        System.out.println(solve(n));

    }

    private static int solve(int n) {

        if(n < 0){
            return 0;
        }

        if(n == 0){
            return 1;
        }

        return solve(n - 1) + solve(n - 2);
    }
}
