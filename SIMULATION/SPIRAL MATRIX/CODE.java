
//problem statement: https://leetcode.com/problems/spiral-matrix/
class Solution {
    public List<Integer> spiralOrder(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;


        int left = 0;
        int right = n - 1;

        int top = 0;
        int bottom = m-1;

        List<Integer> ans = new ArrayList<>();

        while(left <= right && top <= bottom){

            for(int i=left; i<=right; i++){
                ans.add(grid[top][i]);
            }
            top++;

            for(int i=top; i<=bottom; i++){
                ans.add(grid[i][right]);
            }
            right--;

            if(top<=bottom){
                for(int i=right; i>=left; i--){
                    ans.add(grid[bottom][i]);
                }
            }
            bottom--;

            if(left<=right){
                for(int i=bottom; i>=top; i--){
                    ans.add(grid[i][left]);
                }
            }
            left++;
        }

        return ans;
    }
}