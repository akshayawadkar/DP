package com.core;

class SubSetSum{


    static boolean isSubset(int[] arr, int sum, int n){
        if(sum == 0){
            return true;
        }
    
        if(n <= 0 || sum < 0){
            return false;
        }

        if(arr[n - 1] <= sum){
            return isSubset(arr, sum - arr[n - 1], n - 1) || isSubset(arr, sum, n - 1);
        }else{
            return isSubset(arr, sum, n - 1);
        }

    }


    public static void main(String[] args) {
        
        int[] arr = {7, 3, 2, 5 ,8};
        int sum = 18;
        int n = arr.length;
        System.out.println(isSubset(arr, sum, n));
    }
}