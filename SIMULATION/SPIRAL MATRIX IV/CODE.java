class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {

        int[][] grid = new int[m][n];

        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = m-1;

        while(left<=right && top<=bottom){
            for(int i=left; i<=right; i++){
                if(head!=null){
                    grid[top][i] = head.val;
                    head = head.next;
                }else{
                    grid[top][i] = -1;
                }
            }
            top++;

            for(int i=top; i<=bottom; i++){
                if(head!=null){
                    grid[i][right] = head.val;
                    head = head.next;
                }else{
                    grid[i][right] = -1;
                }
            }
            right--;

            if(top<=bottom){
                for(int i=right; i>=left; i--){
                    if(head!=null){
                        grid[bottom][i] = head.val;
                        head = head.next;
                    }else{
                        grid[bottom][i] = -1;
                    }
                }
            }

            bottom--;


            if(left<=right){
                for(int i=bottom; i>=top; i--){
                    if(head!=null){
                        grid[i][left] = head.val;
                        head = head.next;
                    }else{
                        grid[i][left] = -1;
                    }
                }
            }

            left++;
        }
        return grid;

    }
}