package com.core.MCM;

class MCM{
    
    static int solve(int[] arr){

        return solve(arr, 1, arr.length - 1);
    }

    static int solve(int[] arr, int i, int j){


        if(i >= j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j - 1; k++){
            int tmpans = solve(arr, i, k) + solve(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
            System.out.println(i+" "+k+" "+j+"    "+tmpans);
            min = Math.min(min, tmpans);
        }
        return min;
    }   

    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        System.out.println(solve(arr));
    }
}