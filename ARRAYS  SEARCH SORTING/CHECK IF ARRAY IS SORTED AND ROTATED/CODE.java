class Solution {
    public boolean check(int[] nums) {
        // int n = nums.length;
        // boolean isSortedRotated = true;

        // int breakPointIndex = -1;

        // for(int i=0; i<n-1; i++){
        //     if(nums[i+1] < nums[i]){
        //         breakPointIndex = i + 1;
        //         break;
        //     }
        // }

        // if(breakPointIndex==-1)
        //     return true;

        // for(int j=breakPointIndex; j<n-1; j++){
        //     if(nums[j]>nums[j+1]){
        //         return false;
        //     }
        // }

        // if(nums[0]<nums[nums.length-1])
        //     return false;

        // return true;

         int irregularities = 0;
        int length = nums.length;//if more than one irregularities, then return false;
        for (int i=0; i<length; i++) {
            if (nums[i] > nums[(i + 1) % length])
                irregularities += 1;
        }
        return irregularities > 1 ? false : true;

    }
}