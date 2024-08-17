class Solution {
    public static long[] productExceptSelf(int nums[]) {
        long[] res = new long[nums.length];
        
        Arrays.fill(res, 1);
        
        long left = 1;
        long right = 1;
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            res[i] = res[i] * left;
            left = left * nums[i];
        }
        
        for(int i=n-1; i>=0; i--){
            res[i] = res[i]*right;
            right = right*nums[i];
        }
        
        return res;
    }
}
