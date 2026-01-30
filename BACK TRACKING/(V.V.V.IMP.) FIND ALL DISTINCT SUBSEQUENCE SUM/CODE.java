// User function Template for Java

class Solution {

    public int[] DistinctSum(int[] nums)
    {

        int n = nums.length;
        TreeSet <Integer> ts = new TreeSet<>();
        boolean [][] dp = new boolean [n][10001];
        sums(nums,0,0,dp,ts);
        int rtn [] = new int [ts.size()];
        int ptr = 0;
        for(int i : ts){
            rtn[ptr++] = i;
        }

        return rtn;

    }

    // sum

    public void sums(int [] nums, int ptr, int sum, boolean [][] dp, TreeSet <Integer> ts){

        if(ptr == nums.length){
            ts.add(sum);
            return;
        }
        if(dp[ptr][sum]){
            return;
        }

        dp[ptr][sum] = true;
        // including
        sums(nums,ptr+1,sum + nums[ptr],dp,ts);

        // excluding
        sums(nums,ptr+1,sum,dp,ts);

    }
}

