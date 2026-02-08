// User function Template for Java

// problem desc: https://www.geeksforgeeks.org/problems/maximum-value-of-difference-of-a-pair-of-elements-and-their-index/1
//

class Solution {
    public int maxValue(int arr[]) {
        // code here

        int n = arr.length;

        //assume j>i;
        // |arr[i] - arr[j]| + (j-i)
        // if arr[i]>arr[j], (arr[i]-i) - (arr[j]-j)
        //else, (arr[j] + j) - (arr[i] + i)

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        for(int i=0; i<n; i++){
            dp1[i] = arr[i] - i;
            dp2[i] = arr[i] + i;
        }

        return Math.max(getMinAndMax(dp2)[1] - getMinAndMax(dp2)[0], getMinAndMax(dp1)[1] - getMinAndMax(dp1)[0]);

    }

    public int[] getMinAndMax(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i: arr){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int[] dp = new int[2];
        dp[0] = min;
        dp[1] = max;

        return dp;
    }
};