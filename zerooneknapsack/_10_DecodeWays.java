package com.zerooneknapsack;

public class _10_DecodeWays {


    public static void main(String[] args) {

        String ip = "1123";

        System.out.println(solve(ip, 0))  ;

    }

     private static int solve(String s, int idx){

        if(idx == s.length()){
            return 1;
        }

        if(s.charAt(idx) == '0'){
            return 0;
        }

        if(idx == s.length() - 1){
            return 1;
        }

        int way1 = solve(s, idx + 1);
        int way2 = 0;

        if(Integer.parseInt(s.substring(idx, idx + 2)) <= 26){
            way2 = solve(s, idx + 2);
        }

        return way1 + way2;
    }
}
