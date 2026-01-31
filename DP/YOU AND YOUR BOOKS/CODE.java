class Solution {
    long max_Books(int arr[], int n, int k) {

        long ans = 0L;
        int i = 0;
        long sum = 0L;

        while(i < n){
            if(arr[i]<=k){
                while(i<n && arr[i] <= k){
                    sum = sum + arr[i];
                    ans = Math.max(sum, ans);
                    i++;
                }
                i--;
            }
            sum = 0L;
            i++;
        }

        return ans;
    }
}