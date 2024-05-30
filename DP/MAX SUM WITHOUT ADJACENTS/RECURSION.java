class Solution {
    
    int memoization(int[] arr, int[] dp, int index){
        if(index < 0)
            return 0;
            
        if(index == 0)
            return arr[0];
        
        // if(dp[index] != -1)
        //     return dp[index];
            
        int currentIncluded = arr[index] + memoization(arr, dp, index-2);//include current element and then start considering from index -2 
        int currentExcluded = memoization(arr, dp, index-1);// do not include current element, so we will have the freedom of choosing from the index-1
        
        return  Math.max(currentIncluded, currentExcluded);
    }
    
    int findMaxSum(int arr[], int n) {
       int[] dp = new int[n];
       Arrays.fill(dp, -1);
       
       
       
       return memoization(arr, dp, n-1);
    }
}