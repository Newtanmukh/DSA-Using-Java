
//problem desc: https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
// User function Template for Java

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        Collections.sort(arr, new Comparator<Integer>(){

            @Override
            public int compare(Integer lhs, Integer rhs){
                return Integer.compare(lhs, rhs);
            }
        });


        int ans = Integer.MAX_VALUE;

        for(int i=m-1; i<arr.size(); i++){
            int mini = arr.get(i) - arr.get(i-m+1);

            ans = Math.min(ans, mini);
        }

        return ans;
    }
}