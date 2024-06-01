class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int arr[], int n, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        Integer sum = 0;
        Integer ans = 0;
        
        for(int i=0; i<n; i++){
            sum = sum + arr[i];
            
            if(sum == k){
                ans = Math.max(ans, i+1);
            }
            
            if(hashMap.get(sum-k)!=null){
                int prevIndex = hashMap.get(sum - k);
                ans = Math.max(ans, i - prevIndex);// this is because, let us say upto index 2 the sum is 10, and index 4 it is 25, so the sum is 15 which we can get by taking index 3 and 4, which we can find by subtracting the smaller from the bigger.              
            }
            
            if(hashMap.get(sum)==null){
                hashMap.put(sum, i);
            }
        }
        
        return ans;
    }
    
    
}