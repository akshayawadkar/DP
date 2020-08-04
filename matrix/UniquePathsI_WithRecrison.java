package com.matrix;

public class UniquePathsI_WithRecrison {
    public int uniquePaths(int m, int n) {
        return helper(m, n);
    }

    private int helper(int m, int n){

        if(m == 1 || n == 1){
            return 1;
        }

        return helper(m - 1, n) + helper(m, n - 1);

    }
}
