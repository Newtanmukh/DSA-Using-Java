class Solution {

    public int nthUglyNumber(int n) {
        if(n==1)
            return 1;

        int[] dp = new int[n+1];

        Arrays.fill(dp, 1);

        int p2=1, p3=1, p5=1;

        for(int i=2; i<=n; i++){
            int mini = Math.min(dp[p2]*2, Math.min(dp[p3]*3, dp[p5]*5));

            dp[i] = mini;

            if(mini==dp[p2]*2){
                p2++;
            }

            if(mini==dp[p3]*3){
                p3++;
            }

            if(mini==dp[p5]*5){
                p5++;
            }
        }
        return dp[n];
    }
}