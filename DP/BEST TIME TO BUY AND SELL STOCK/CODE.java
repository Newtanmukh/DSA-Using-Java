

//problem desc. : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int minTillNow = Integer.MAX_VALUE/2;

        for(int price: prices){
            minTillNow = Math.min(price, minTillNow);
            ans = Math.max(ans, price - minTillNow);
        }

        return ans;
    }
}