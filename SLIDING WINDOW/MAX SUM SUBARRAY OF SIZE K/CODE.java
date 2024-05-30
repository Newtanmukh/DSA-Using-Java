class Solution{
    static long maximumSumSubarray(int k, ArrayList<Integer> arr,int n){
       long sum = 0;
       
       for(int i=0; i<k; i++){
           sum = sum + arr.get(i);
       }
       
       long ans = sum;
       
       for(int i=k; i<n; i++){
           sum = sum + arr.get(i) - arr.get(i-k);
           ans = Math.max(ans, sum);
       }
       
        return ans;
    }
}