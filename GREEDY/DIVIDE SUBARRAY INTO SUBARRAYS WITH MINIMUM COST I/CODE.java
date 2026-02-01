class Solution {
    public int minimumCost(int[] nums) {

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int n = nums.length;

        for(int i=1; i<n; i++){
            if(nums[i] < min1){
                min2 = min1;
                min1 = nums[i];
            }else if(nums[i] < min2){
                min2 = nums[i];
            }
        }


        return nums[0] + min1 + min2;
    }
}