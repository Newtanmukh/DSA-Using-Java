// User function Template for Java

import java.util.Arrays;

class Code {

    int[] dp;
    public int dfs(int idx, int[] arr){
        if(idx==0 || idx<0)
            return 0;

        if(dp[idx]!=-1)
            return dp[idx];

        int consider = arr[idx-1] + dfs(idx-2, arr);
        int notConsider = dfs(idx-1, arr);

        return dp[idx] = Math.max(consider, notConsider);
    }

    int findMaxSum(int[] arr, int n) {
        // code here
        dp = new int[n+1];
        Arrays.fill(dp, -1);

        return dfs(n, arr);
    }
}