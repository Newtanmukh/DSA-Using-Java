//problem link : https://www.geeksforgeeks.org/problems/boolean-matrix-problem-1587115620/1
class Solution {
    void booleanMatrix(int mat[][]) {
        // code here
        int m = mat.length;
        int n = mat[0].length;

        int[] rows = new int[m];
        int[] cols = new int[n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 1){
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rows[i]==1 || cols[j]==1){
                    mat[i][j] = 1;
                }
            }
        }
    }
}