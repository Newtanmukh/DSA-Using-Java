

//problem statement: https://www.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1
class Solution {
    public void rotateMatrix(int[][] mat) {
        // code here
        int n = mat.length;

        // int[][] dp = new int[n][n];

        for(int j=0; j<n; j++){
            for(int i=0; i<j; i++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for(int j=0; j<n; j++){
            for(int i=0; i<n-1-i; i++){
                int temp = mat[i][j];
                mat[i][j] = mat[n-1-i][j];
                mat[n-1-i][j] = temp;
            }
        }

    }
}