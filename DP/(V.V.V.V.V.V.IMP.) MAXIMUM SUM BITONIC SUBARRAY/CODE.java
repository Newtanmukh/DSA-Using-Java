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


        for(int i=0; i<n; i++){
            if(i>0){
                if(arr[i]>arr[i-1]){
                    left[i] = left[i-1] + arr[i];
                }else{
                    left[i] = arr[i];
                }
            }else{
                left[i] = arr[i];
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--){
            if(i==n-1){
                right[i] = arr[i];
            }else{
                if(arr[i]>arr[i+1]){
                    right[i] = right[i+1] + arr[i];
                }else{
                    right[i] = arr[i];
                }
            }

            ans = Math.max(left[i] + right[i] - arr[i], ans);
        }

        return ans;

    }
}