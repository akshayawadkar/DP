package com.core;

class PartitionProblem{


    static boolean subsetsum(int[] arr, int sum, int n){
        if(sum == 0){
            return true;
        }
    
        if(n <= 0 || sum < 0){
            return false;
        }

        if(arr[n - 1] <= sum){
            return subsetsum(arr, sum - arr[n - 1], n - 1) || subsetsum(arr, sum, n - 1);
        }else{
            return subsetsum(arr, sum, n - 1);
        }

    }



    static boolean solve(int[] arr){
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        if(sum % 2 != 0){
            return false;
        }

        return subsetsum(arr, sum, arr.length );
    }


    public static void main(String[] args) {
        int[] arr = {7, 3, 1, 5, 4, 8};
        System.out.println(solve(arr));
    }
}