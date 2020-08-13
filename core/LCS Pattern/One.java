package com.core.LCS;//LCS Length Recursive

class One{


    static int solve(String X, String Y, int m, int n){

        if(m == 0 || n == 0){
            return  0;
        }

        if(X.charAt(m - 1) == Y.charAt(n - 1)){
            return 1 + solve(X, Y, m - 1, n - 1);
        }else{
            return Math.max(solve(X, Y, m - 1, n), solve(X, Y, m, n - 1));
        }
    }


    public static void main(String[] args) {
        
        String X = "abcdgh";
        String Y = "abedfhr";
        System.out.println(solve(X, Y, X.length(), Y.length()));

    }
}