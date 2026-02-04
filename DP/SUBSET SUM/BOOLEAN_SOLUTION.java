class Solution {
    // RECURSION
    // public int recursion(int sum, int idx, int[] arr){

    //     if(sum == 0 && idx==0){
    //         return 1;
    //     }

    //     if(idx==0)
    //         return 0;



    //     int consider = recursion(sum - arr[idx-1], idx-1, arr);
    //     int notConsider = recursion(sum, idx-1, arr);

    //     return consider + notConsider;
    // }

    int[][] dp;

    // MEMOIZATION
    public boolean memo(int sum, int idx, int[] arr){

        if (sum == 0){
            return true;
        }


        if(dp[sum][idx]>=0)
            return dp[sum][idx]==1 ? true : false;

        if(idx==0)
            return false;

        boolean consider = false;

        if(sum>=arr[idx-1])
            consider = memo(sum - arr[idx-1], idx-1, arr);

        boolean notConsider = memo(sum, idx-1, arr);

        dp[sum][idx] = (consider || notConsider) ? 1: 0;

        return dp[sum][idx]==1 ? true : false;
    }

    Boolean isSubsetSum(int arr[], int sum) {

        dp = new int[sum+1][arr.length+1];

        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        boolean waus = memo(sum, arr.length, arr);

        return dp[sum][arr.length] ==1  ? true : false;
    }
}