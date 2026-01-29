class Solution {

    ArrayList<ArrayList<Integer>> ans;

    public void dfs(int sum, ArrayList<Integer> list, int idx, int[] arr){

        if(sum==0 && idx==0){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(idx==0)
            return;

        if(sum < arr[idx-1]){
            dfs(sum, list, idx-1, arr);
        }else{
            dfs(sum, list, idx-1, arr);

            list.add(arr[idx-1]);
            dfs(sum-arr[idx-1], list, idx, arr);
            list.remove(list.size() - 1);
        }

    }

    public ArrayList<ArrayList<Integer>> targetSumComb(int[] arr, int target) {
        ans = new ArrayList<>();

        dfs(target, new ArrayList<>(), arr.length, arr);

        return ans;
    }
}