
//problem desc. : https://leetcode.com/problems/permutations/submissions/1918134573/

class CODE {
    List<List<Integer>> list;

    public void dfs(int idx, int n, int[] nums){
        if(idx==n){
            list.add(getListFromArray(nums));
            return;
        }

        for(int i = idx; i<n; i++){
            swap(i, idx, nums);
            dfs(idx+1, n, nums);
            swap(i, idx, nums);
        }
    }

    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<Integer> getListFromArray(int[] nums){
        List<Integer> newList = new ArrayList<>();
        for(int i: nums){
            newList.add(i);
        }

        return newList;
    }

    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<>();
        dfs(0, nums.length, nums);

        return list;
    }
}
