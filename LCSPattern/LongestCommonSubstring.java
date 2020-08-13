package com.LCSPattern;

public class LongestCommonSubstring {

     private static int solve(String X, String Y){
         int result = helper(X, Y, X.length(), Y.length(), 0);
         return result;
     }

     private static int helper(String X, String Y, int m, int n, int result){

         if(m == 0 || n == 0){
             return result;
         }
         int tmp = 0;
         if(X.charAt(m - 1) == Y.charAt(n - 1)){
             tmp = helper(X, Y, m - 1, n - 1, result + 1);
         }else{
             tmp = Math.max(helper(X, Y, m - 1, n, 0),
                            helper(X, Y, m, n - 1, 0));
         }

         return tmp;
     }


    public static void main(String[] args) {

        String X = "abcde";
        String Y = "abfce";
        System.out.println("LongestCommonSubstring");
        System.out.println(solve(X, Y));

    }


}
