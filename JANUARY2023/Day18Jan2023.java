package JANUARY2023;

import java.util.Scanner;

public class Day18Jan2023 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int [n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        int res = maxSubArraySumCircular(arr);
        System.out.println(res);
    }

    private static int maxSubArraySumCircular(int[] nums) {
        final int n = nums.length;
        final int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int suffixSum = nums[n - 1], i = n - 2; i >= 0; --i) {
            suffixSum += nums[i];
            rightMax[i] = Math.max(rightMax[i + 1], suffixSum);
        }
        int maxSum = nums[0];
        int specialSum = nums[0];
        for (int i = 0, prefixSum = 0, curMax = 0; i < n; ++i) {
            curMax = Math.max(curMax, 0) + nums[i];
            // This is Kadane's algorithm.
            maxSum = Math.max(maxSum, curMax);
            prefixSum += nums[i];
            if (i + 1 < n) {
                specialSum = Math.max(specialSum, prefixSum + rightMax[i + 1]);
            }
        }
        return Math.max(maxSum, specialSum);
    }
    
}
