package com.LCSPattern;

public class PrintLCS {

    private static String solve(String X, String Y){
        int[][] dp = getMatrix(X, Y);

        String result = printLCS(X, Y, X.length(), Y.length(), dp);
        return result;
    }

    private static String printLCS(String X, String Y, int m, int n, int[][] dp) {

        if(m == 0 || n == 0){
            return "";
        }

        if(X.charAt(m - 1) == Y.charAt(n - 1)){
            return printLCS(X, Y, m - 1, n - 1, dp) + X.charAt(m - 1);
        }else{
            if(dp[m - 1][n] > dp[m][n - 1]){
                return printLCS(X, Y, m - 1, n, dp);
            }else{
                return printLCS(X, Y, m, n - 1, dp);
            }
        }
    }


    private static int[][] getMatrix(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(X.charAt(i - 1) == Y.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {


        String X = "ABCBDAB", Y = "BDCABA";
        System.out.println(solve(X, Y));

    }
}
