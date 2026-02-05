//problem link: https://www.geeksforgeeks.org/problems/boundary-traversal-of-matrix-1587115620/1

class Solution {
    public ArrayList<Integer> boundaryTraversal(int mat[][]) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int m = mat.length;
        int n = mat[0].length;

        for(int j=0; j<n; j++){
            list.add(mat[0][j]);
        }

        for(int i=1; i<m; i++){
            list.add(mat[i][n-1]);
        }

        if(m>1){
            for(int j=n-2; j>=0; j--){
                list.add(mat[m-1][j]);
            }
        }

        if(n>1){
            for(int i=m-2; i>=1; i--){
                list.add(mat[i][0]);
            }
        }

        return list;
    }
}
