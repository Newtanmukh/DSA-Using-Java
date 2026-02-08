
//problem dexc leetcode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/1912293174/
//provlem desc gfg:
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;

        for(int i=1; i<prices.length; i++){
            if(prices[i]>prices[i-1]){
                ans = ans + (prices[i] - prices[i-1]);
            }
        }

        return ans;
    }
}