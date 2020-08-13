package com.LCSPattern;

public class LongestCommonSubstring_TopDown {
    private static int solve(String X, String Y){

        int result = helper(X, Y, X.length(), Y.length());
        return result;
    }

    private static int helper(String X, String Y, int m, int n) {

        int[][] dp = new int[X.length() + 1][Y.length() + 1];
        int result = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(X.charAt(i - 1) == Y.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        String X = "abcdgh";
        String Y = "abedfhr";
        System.out.println(solve(X, Y));
    }
}
