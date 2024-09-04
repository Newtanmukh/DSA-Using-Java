class Solution {

   int n;
    int[][] dp;

    public int returnMinCost(int currentLength, int clipBoardLength){
        if(currentLength > n)
            return Integer.MAX_VALUE/2;

        if(currentLength == n)
            return 0;

        if(dp[currentLength][clipBoardLength] != -1)
            return dp[currentLength][clipBoardLength];

        if(currentLength==clipBoardLength)
            return dp[currentLength][clipBoardLength] = 1 + returnMinCost(2*currentLength, currentLength);
            //if length is same , why the hell would we even copy? just paste it .

        int copy = 1 + returnMinCost(currentLength, currentLength);
        int paste = 1 + returnMinCost(currentLength + clipBoardLength, clipBoardLength);

        return dp[currentLength][clipBoardLength] = Math.min(copy, paste);
    }

    public int minSteps(int n) {
        if(n==1)
            return 0;

        
        this.n = n;

        dp = new int[n+1][n+1];

        for(int i=0; i<n+1; i++){
            Arrays.fill(dp[i], -1);
        }

        

        return 1 + returnMinCost(1, 1);
        //This one is necessary to paste the initial A on screen. initially on screen nothing is present.
    }
}