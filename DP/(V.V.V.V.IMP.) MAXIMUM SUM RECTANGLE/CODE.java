//problem statement: https://www.geeksforgeeks.org/problems/maximum-sum-rectangle2948/1

class Solution {
    public int maxRectSum(int mat[][]) {

        int n = mat.length;
        int m = mat[0].length;

        int ans = Integer.MIN_VALUE;

        for(int top=0; top<n; top++){
            int[] temp = new int[m];

            for(int bottom=top; bottom<n; bottom++){
                for(int col = 0; col<m; col++){
                    temp[col] += mat[bottom][col];
                }
                int kad = kadane(temp);
                ans = Math.max(kad, ans);
            }


        }

        return ans;
    }



    private int kadane(int[] dp){
        int max = Integer.MIN_VALUE;
        int curr = 0;

        for(int i=0; i<dp.length; i++){
            curr = Math.max(curr + dp[i], dp[i]);
            max = Math.max(max, curr);
        }

        return max;
    }

};