//Problem statement: https://www.geeksforgeeks.org/problems/handshakes1303/1

class Code {
    static int count(int n) {
        // code here
        n = n/2;

        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);

        if(n==1)
            return 1;

        // number of ways of having 0 handshakes, its
        dp[0] = 1;

        for(int i=1; i<n+1; i++){

            for(int j=0; j<i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        return dp[n];
    }
};