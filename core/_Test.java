package com.core;

class _Test{


    private static int solve(int[] arr, int n){

        if(n == arr.length - 2){
            return 0;
        }

        
        return Math.max(solve(arr, n + 1), solve(arr, n + 2)) + arr[n];

    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(solve(arr, 0));

    }


}