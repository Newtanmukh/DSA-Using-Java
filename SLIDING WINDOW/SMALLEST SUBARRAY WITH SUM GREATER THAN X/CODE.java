class Solution {
    public static int smallestSubWithSum(int x, int[] arr) {

        int i = 0;
        int j = 0;
        int n = arr.length;

        int ans = Integer.MAX_VALUE;

        int sum = 0;

        while(j < n){
            sum = sum + arr[j];

            while(sum > x){
                ans = Math.min(ans, j-i+1);
                sum = sum - arr[i];
                i++;
            }

            j++;
        }

        return ans==2147483647 ? 0 : ans;
    }
}
