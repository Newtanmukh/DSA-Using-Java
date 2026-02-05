// User function Template for Java
// problem desc. : https://www.geeksforgeeks.org/problems/matrix-operations/1
class Solution {

    public static int[] endPoints(int [][]arr, int m, int n){
        // UP Dir is 0, right is 1, down is 2, left is 3.
        int dir = 0;

        // int m = arr.length;
        // int n = arr[0].length;

        int[] dp = new int[2];
        int i = 0;
        int j = 0;

        while(isValid(i, j, arr)){

            if(arr[i][j]==1){
                arr[i][j] = 0;
                dir = (dir + 1)%4;
            }

            dp[0] = i;
            dp[1] = j;

            if(dir==0)
                j = j+1;

            if(dir==1)
                i += 1;

            if(dir==2)
                j -= 1;

            if(dir==3)
                i-=1;
        }

        return dp;
    }

    private static  boolean isValid(int i, int j, int[][] arr){

        return i>=0 && j>=0 && i<arr.length && j<arr[0].length;
    }

}