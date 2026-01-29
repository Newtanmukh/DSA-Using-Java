
//PROBLEM : https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
class Solution {
    ArrayList<String> list;
    public int dfs(int i, int j, int[][] maze, String s){

        if(!isValidCell(i, j, maze)){
            return 0;
        }

        if(isTerminalCell(i, j, maze)){
            list.add(s);
            return 1;
        }

        int val = maze[i][j];
        maze[i][j] = -1;

        int ans = 0;

        ans += dfs(i+1, j, maze, s+"D");
        ans += dfs(i, j-1, maze, s+"L");
        ans += dfs(i, j+1, maze, s+"R");
        ans += dfs(i-1, j, maze, s+"U");

        maze[i][j] = val;

        return ans;
    }

    public boolean isTerminalCell(int i, int j, int[][] maze){
        if(i==maze.length-1 && j==maze[0].length-1)
            return true;

        return false;
    }

    public boolean isValidCell(int i, int j, int[][] maze){
        if(i<0 || j<0 || i>=maze.length || j>= maze[0].length)
            return false;

        if(maze[i][j]==0 || maze[i][j]==-1)
            return false;

        return true;
    }

    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        list = new ArrayList<>();

        int x = dfs(0, 0, maze, "");
        // System.out.println("Number of paths are : " + x);
        return list;
    }
}