package com.MCM;

public class MCM {

    private static int solve(int[] arr){
        int result = helper(arr, 1, arr.length - 1);
        return result;
    }

    private static int helper(int[] arr, int start, int end){


        if(start == end){
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for(int k = start; k < end; k++){

            int tmp = helper(arr, start, k)
                     + helper(arr, k + 1, end)
                     + (arr[start - 1] * arr[k] * arr[end]);
            min = Math.min(tmp, min);
        }


        return min;
    }


    public static void main(String[] args) {

        int[] arr = {40, 20, 30, 10, 30};
        System.out.println(solve(arr));
    }
}
