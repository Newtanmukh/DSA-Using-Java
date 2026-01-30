class Solution {

    //RECURSIVE
    int ans;
    void dfs(int n, int square){
        if(n<0)
            return;

        if(n==0){
            ans = Math.min(ans, square);
        }

        for(int i=1; i*i<=n; i++){
            dfs(n-i*i, square + 1);
        }
    }


    //MEMOIZATION
    int[] dp;
    int dfs(int n){

        if(n==0)
            return 0;

        if(dp[n]!=-1)
            return dp[n];

        int x = Integer.MAX_VALUE;

        for(int i=1; i*i<=n; i++){
            x = Math.min(x, 1 + dfs(n-i*i));
        }

        return dp[n] = x;
    }

    public int minSquares(int n) {
        // Code here
        ans = Integer.MAX_VALUE;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dfs(n);

        return dp[n];
    }
}