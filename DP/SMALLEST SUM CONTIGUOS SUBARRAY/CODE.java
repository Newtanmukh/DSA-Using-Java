// https://www.geeksforgeeks.org/problems/smallest-sum-contiguous-subarray/1



class Solution
{
    int smallestSumSubarray(int a[], int size)
    {
        int[] dp = new int[size];
        
        for(int i=0; i<size; i++){
            a[i] = (-1) * a[i];
        }
        
        
        dp[0] = a[0];
        int maxi = dp[0];
        for(int i=1; i<size; i++){
            dp[i] = Math.max(dp[i-1] + a[i], a[i]);
            maxi = Math.max(dp[i], maxi);
        }
        
        return -maxi;
    }
}