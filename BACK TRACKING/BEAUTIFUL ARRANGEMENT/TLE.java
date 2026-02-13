

class Solution {
    int count = 0;

    void dfs(int idx, int n, int[] nums){
        if(idx==n){
            if(isBeautiful(nums)){
                count++;
            }
            return;
        }

        for(int i=idx; i<n; i++){
            swap(i, idx, nums);
            dfs(idx+1, n, nums);
            swap(i, idx, nums);
        }
    }

    public boolean isBeautiful(int[] nums){
        int n = nums.length;
        for(int i=0; i<n; i++){
            int j = i+1;
            if(nums[i]%j!=0 && j%nums[i]!=0)
                return false;
        }
        return true;
    }

    void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int countArrangement(int n) {
        int[] nums = new int[n];
        count = 0;
        for(int i=0; i<n; i++){
            nums[i] = i + 1;
        }

        dfs(0, n, nums);

        return count;
    }
}