class Solution {

    class Pair {
        public int height;
        public int money;
        public int previous;

        Pair(int height, int money, int previous){
            this.height = height;
            this.money = money;
            this.previous = previous;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair p = (Pair) o;
            return height == p.height && money == p.money && previous == p.previous;
        }
    }

    private Map<Pair, Integer> map;

    //MEMOIZATION
    public int dfs(int level, int h, int m, int[] health, int[] money, int previousSelectedIndex){
        if(h<1 || m<1){
            return level-1;
        }

        Pair pair = new Pair(h, m, previousSelectedIndex);

        if(map.containsKey(pair))
            return map.get(pair);

        int ans = -1;

        for(int i=0; i<3; i++){
            if(i!=previousSelectedIndex){
                ans = Math.max(ans, dfs(level+1, h-health[i], m-money[i], health, money, i));

            }
        }
        map.put(new Pair(h, m, previousSelectedIndex), ans);
        return ans;
    }

    public int maxLevel(int h, int m) {
        // code here

        map = new HashMap<>();
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
