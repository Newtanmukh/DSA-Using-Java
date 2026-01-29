// User function Template for Java
class Solution {
    //basically determines the number of ways of valid starting
    //string from index 'idx'.
    int[] dp;
    public int dfs(int idx, char[] ch){
        //means all characters been considered.
        if(idx==ch.length){
            return 1;
        }

        int considerSingleCharacter = 0;
        int considerDoubleCharacters = 0;

        if(dp[idx]!=-1)
            return dp[idx];

        char c = ch[idx];

        if(c>='1' && c<='9'){
            considerSingleCharacter = dfs(idx+1, ch);
        }

        if(idx+1<ch.length){
            String res = String.valueOf(ch[idx]) + String.valueOf(ch[idx+1]);

            if(res.compareTo("10")>=0 && res.compareTo("26") <=0){
                considerDoubleCharacters = dfs(idx+2, ch);
            }
        }

        return dp[idx] = considerDoubleCharacters + considerSingleCharacter;
    }

    public int countWays(String digits) {
        // code here

        char[] arr = digits.toCharArray();
        dp = new int[arr.length+1];
        Arrays.fill(dp, -1);
        return dfs(0, arr);

    }
}