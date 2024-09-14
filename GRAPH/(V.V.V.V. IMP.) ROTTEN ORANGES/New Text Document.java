class Solution {
    public int orangesRotting(int[][] grid) {
       if(grid==null)
           return 0;
        
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        if(rows==0 || cols==0)
            return 0;

        if(rows==1 && cols==1){
            return grid[0][0] == 1 ? -1 : 0;
        }

        class Pair{
            int i;
            int j;
            Pair(int i, int j){
                this.i = i;
                this.j = j;
            }
        }

        Deque<Pair> deque =  new ArrayDeque<>();
        int freshOrangesCount = 0;

        for(int i=0; i<rows; i++)
            for(int j = 0; j<cols; j++){
                if(grid[i][j]==2){
                    deque.addLast(new Pair(i, j));//putting all rotten oranges to the deque.
                }else if(grid[i][j]==1){
                    freshOrangesCount++;
                }
        }

        int time = 0;

        int[] dx = new int[]{0, 1, 0 , -1};
        int[] dy = new int[]{-1, 0, 1, 0};

        while(freshOrangesCount != 0 && deque.size() > 0){
            //freshOrangesCount != 0,  check is necessary as suppose if all in the deques are rotten oranges only, in that case, time would be 1.
            //also let us say all  fresh Oranges have been rotten, so they are in the deque now. Now, while they were being put, although the queue size was big. still all the fresh have rotten by npw. so no need to consider it.

            int levelSize = deque.size();
            time++;

            for(int i=0; i<levelSize; i++){
                Pair front = deque.peekFirst();
                deque.removeFirst();

                int currRow = front.i;
                int currCol = front.j;

                for(int j=0; j<4; j++){
                    int x = currRow + dx[j];
                    int y = currCol + dy[j];

                    if(x<0 || y<0 || x>=rows || y>=cols || grid[x][y] != 1){
                        continue;
                    }

                    grid[x][y] = 2; //turn it from fresh to rotten orange.

                    freshOrangesCount--;

                    if(freshOrangesCount==0){
                        break;
                    }

                    deque.addLast(new Pair(x, y));
                }
            }
        }

        return freshOrangesCount == 0 ? time : -1;
        //let us say one of the fresh orange was very far away, then there is now way it can ever rot.

    }
}