class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> hashSet = new HashSet<>();
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
      
        if(n<3)
            return ans;

        for(int i=0; i<n-2; i++){
            int j = i+1;
            int k = n-1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    hashSet.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;//consider this array : [a, b, b, c, d, e]. now lets say a is fixed, b+d + a  = sum. npw omcrease pointer, agaont te same list, no issue.again,
                    //[a, b, c,f, d, d, e] again lets say a + c + d = sum, then if we increment, then also OK since the rightMost element will definitely be smaller than d.(as left increase, right must decrease).
                     
                }else if(sum<0){
                    j++;
                }else{
                    k--;
                }
            }
        }

        ans.addAll(hashSet);

        return ans;

    }
}