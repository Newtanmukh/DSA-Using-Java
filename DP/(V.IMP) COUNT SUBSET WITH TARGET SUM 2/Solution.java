
//problem : https://www.geeksforgeeks.org/problems/count-the-subset-with-sum-equal-to-k/1


class Solution {


    // for all the 2^n
    public int countSubset(int[] arr, int k) {
        int n = arr.length;

        int mid = n/2;

        int[] leftArr = populateArray(0, mid, arr);
        int[] rightArr = populateArray(mid+1, n-1, arr);


        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        dfs(0, leftArr, left, 0);
        dfs(0, rightArr, right, 0);

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<left.size(); i++){
            int elm = left.get(i);
            map.put(elm, map.getOrDefault(elm, 0) + 1);
        }

        int ans = 0;

        for(int i=0; i<right.size(); i++){
            int elm = right.get(i);
            ans += map.getOrDefault(k-elm, 0);
        }

        return ans;
    }

    public void dfs(int idx, int[]dp, List<Integer> list, int sum){
        if(idx==dp.length){
            list.add(sum);
            return;
        }

        dfs(idx+1, dp, list, sum + dp[idx]);
        dfs(idx+1, dp, list, sum);
    }

    public int[] populateArray(int low, int high,  int[] arr){
        int[] populate = new int[high-low+1];

        for(int i=low; i<high+1; i++){
            populate[i-low] = arr[i];
        }

        return populate;
    }

}
