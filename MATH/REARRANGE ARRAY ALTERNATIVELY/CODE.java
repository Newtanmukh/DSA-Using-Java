//problem desc: https://www.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1
class Solution {
    public void rearrange(int arr[]) {
        // code here

        Arrays.sort(arr);
        int n = arr.length;
        int i = 0;
        int[] dp = new int[n];
        for(int j=1; j<n; j+=2){
            dp[j] = arr[i];
            i++;
        }
        i = n-1;
        for(int j=0; j<n; j+=2){
            dp[j] = arr[i];
            i--;
        }

        for(i=0; i<n; i++)
            arr[i] = dp[i];

    }
}
