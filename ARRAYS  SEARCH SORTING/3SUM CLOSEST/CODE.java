class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        Integer minDifference = Integer.MAX_VALUE;
        Integer closestSum = 0;
        
        for(int i=0; i<n-2; i++){
            int low = i+1;
            int high = n-1;

            while(low<high){
                int sum = nums[low] + nums[high] + nums[i];
                int difference = Math.abs(target - sum);

                if(sum==target){
                    return sum;
                }else if(sum>target){
                    if(difference < minDifference){
                        minDifference = difference;
                        closestSum = sum;
                    }
                    high--;
                }else{
                    if(difference < minDifference){
                        minDifference = difference;
                        closestSum = sum;
                    }
                    low++;
                }
            }
        }

        return closestSum;
    }
}