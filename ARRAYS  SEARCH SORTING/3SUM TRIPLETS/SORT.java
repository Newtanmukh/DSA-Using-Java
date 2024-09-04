class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<n-2; i++){

            if(i>0 && nums[i]==nums[i-1])
                continue; /*
                            why, see the reason. suppose that the
                            array is like this: [a, a, a, b, c]
                            now there are three cases:

                            i) considering only a, b and c the required sum would have been there. then we will just omit a incase it ever comes again.
                            ii) suppose that the required sum was using 2 a's and one of b or c. then, the b or c value would be sum-2*a. now if we do not omnit the repeated a, then we will end up considering a, a and either of b or c again. not good.
                            iii) sum = 3*a. in this case, if a already considered once, then do not consider it again,
                 */

            int j = i+1;
            int k = n-1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum==0){
                    List<Integer> newList = new ArrayList<>();
                    newList.add(nums[i]);
                    newList.add(nums[j]);
                    newList.add(nums[k]);
                    ans.add(newList);

                    int lowestLastOccurence = nums[j];
                    int highestLastOccurence = nums[k];

                    while(j<k && nums[j]==lowestLastOccurence){
                        j++;//this is because nums[i] is fixed, and nums[j] is also considered so the third element also will be same. thats why d o this.
                    }

                    while(j<k && nums[k]==highestLastOccurence){
                        k--;//Similar as above step.
                    }
                }else if(sum>0){
                    k--;
                }else if (sum<0){
                    j++;
                }
            }
        }
        return ans;
    }
}