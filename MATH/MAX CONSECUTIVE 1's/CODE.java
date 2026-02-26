
//problem desc: https://www.geeksforgeeks.org/problems/longest-consecutive-1s-1587115620/1
class Solution {
    public static int maxConsecutiveOnes(int n) {
        // code here

        int ans = 0;
        int len = 0;
        while(n > 0){
            if( (n & 1) == 1){
                ans++;
            }else{
                ans = 0;
            }
            len = Math.max(len, ans);
            n = n>>1;
        }

        return len;
    }
}
