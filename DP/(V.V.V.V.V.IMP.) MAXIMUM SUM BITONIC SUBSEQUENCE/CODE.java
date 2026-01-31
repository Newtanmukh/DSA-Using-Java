// User function Template for Java

class Solution {
    public int maxSumBS(int[] arr) {
        //IDEA: take two arrays.
        //One, to keep track of the max increasing subarray ending at index i.
        //other, the max decreasing subarray decreasubg at index i.
        //left[i] + right[i] - arr[i]

        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int ans = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            left[i] = arr[i];

            for(int j=0; j<i; j++){
                if(arr[i]>arr[j]){
                    left[i] = Math.max(left[j] + arr[i], left[i]);
                }
            }
        }

        for(int i=n-1; i>=0; i--){
            right[i] = arr[i];

            for(int j=n-1; j>i; j--){
                if(arr[i]>arr[j]){
                    right[i] = Math.max(right[i], right[j] + arr[i]);
                }
            }
        }

        for(int i=0; i<n; i++){
            ans = Math.max(ans, left[i] + right[i] - arr[i]);
        }

        return ans;

    }
}