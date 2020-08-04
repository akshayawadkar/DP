package com.zerooneknapsack;

import java.util.Arrays;

public class _8_MinStepsToReach1 {

    public static void main(String[] args) {
        int n = 10;

        System.out.println(solve(n));
    }

    private static int solve(int n) {

        if(n == 1){
            return 0;
        }

        int op1 = solve(n - 1);
        int minSteps = op1;

        if(n % 2 == 0){
            int tmp = solve(n / 2);
            minSteps = Math.min(minSteps, tmp);
        }

        if(n % 3 == 0){
            int tmp = solve(n / 3);
            minSteps = Math.min(minSteps, tmp);
        }

        return minSteps + 1;
    }
}
