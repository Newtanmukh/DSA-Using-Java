class Solution {

    public int dfs(int level, int h, int m, int[] health, int[] money, int previousSelectedIndex){
        if(h<1 || m<1){
            return level-1;
        }

        int ans = -1;

        for(int i=0; i<3; i++){
            if(i!=previousSelectedIndex){
                ans = Math.max(ans, dfs(level+1, h-health[i], m-money[i], health, money, i));

            }
        }

        return ans;
    }

    public int maxLevel(int h, int m) {
        // code here

        int[] health = new int[3];
        int[] money = new int[3];

        health[0] = 20;
        health[1] = 5;
        health[2] = -3;

        money[0] = -5;
        money[1] = 10;
        money[2] = -2;

        int ans = -1;

        for(int i=0; i<3; i++){
            ans = Math.max(ans, dfs(1, h-health[i], m-money[i], health, money,i));
        }

        return ans;
    }
}
