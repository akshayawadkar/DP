package com.core;

import java.util.*;

class SubSetSumII{

    static Map<String, Boolean> map = new HashMap<>();
    static boolean isSubset(int[] arr, int sum, int n){
        if(sum == 0){
            return true;
        }
    
        if(n <= 0 || sum < 0){
            return false;
        }
        if(map.containsKey(sum+","+n)){
            return map.get(sum+","+n);
        }

        if(arr[n - 1] <= sum){
            map.put(sum+","+n, isSubset(arr, sum - arr[n - 1], n - 1) || isSubset(arr, sum, n - 1));
            return map.get(sum+","+n);
        }else{
            map.put(sum+","+n, isSubset(arr, sum, n - 1));
            return map.get(sum+","+n);
        }

    }


    public static void main(String[] args) {
        
        int[] arr = {7, 3, 2, 5 ,8};
        int sum = 29;
        int n = arr.length;
        
        System.out.println(isSubset(arr, sum, n));
    }
}