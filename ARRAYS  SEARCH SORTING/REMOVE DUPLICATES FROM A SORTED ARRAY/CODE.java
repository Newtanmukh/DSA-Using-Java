class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;

        int[] copy = new int[length];
        Arrays.fill(copy, 0);

        int index = 0;

        for(int i=0; i<length; i++){
            nums[index] = nums[i];
                index++;
            if(i+1 < length && nums[i]==nums[i+1]){
                while(i+1 < length && nums[i]==nums[i+1]){
                    i++;
                }
            }
        }


        int ans = index;

        // for(int i=index; i<length; i++){
        //     nums[i] = -1;
        // }

        return ans;
    }
}