


//provlem desc: https://www.geeksforgeeks.org/problems/max-xor-subarray-of-size-k/1
class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int max = 0;
        int ans = 0;
        int n = arr.length;
        for(int i=0; i<k; i++){
            ans = ans ^ arr[i];
        }

        max = Math.max(max, ans);

        for(int i=k; i<n; i++){
            ans = ans ^ arr[i];
            ans = ans ^ arr[i-k];

            max = Math.max(max, ans);
        }


        return max;

    }
}
