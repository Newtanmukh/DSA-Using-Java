class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int pIndex = -1;
        int qIndex = -1;

        for(int i=1; i<n; i++){
            if(nums[i]>nums[i-1] && i+1<n && nums[i+1] < nums[i]){
                pIndex = i;
                break;
            }
        }

        for(int i=1; i<n; i++){
            if( (nums[i] < nums[i-1]) && (i+1<n) && (nums[i] < nums[i+1])) {
                qIndex = i;
                break;
            }
        }

        if(pIndex==-1 || qIndex==-1 || qIndex<=pIndex)
            return false;

        for(int i=0; i<pIndex+1; i++){
            if(i>0 && nums[i]<=nums[i-1])
                return false;
        }

        for(int i=pIndex; i<=qIndex; i++){
            if(i>pIndex && nums[i]>=nums[i-1])
                return false;
        }

        for(int i=qIndex; i<n; i++){
            if(i>qIndex && nums[i]<=nums[i-1])
                return false;
        }

        return true;
    }
}