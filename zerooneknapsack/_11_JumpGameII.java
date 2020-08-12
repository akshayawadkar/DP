package com.zerooneknapsack;

import java.util.Arrays;

public class _11_JumpGameII {


        static long [] dp;
        public int jump(int[] nums) {
            dp = new long[nums.length + 1];
            Arrays.fill(dp, -1);
            return solve(nums);
        }

        private static int solve(int[] arr){
            int result = (int) helper(arr, 0, arr.length - 1);
            return result;
        }


        private static long helper(int[] arr, int curr, int dest){

            if(curr >= dest){
                return 0;
            }

            long result = Integer.MAX_VALUE;

            if(dp[curr] != -1){
                return dp[curr];
            }

            for(int i = 1; i <= arr[curr]; i++){
                result = Math.min(result, 1 + helper(arr, curr + i, dest));
            }

            return dp[curr] = result;
        }

}
