class Solution {

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array
    
    // return the maximum length of the subarray
    // with equal 0s and 1s
    int maxLen(int[] arr, int n)
    {
        for(int i=0; i<n; i++){
            if(arr[i]==0){
                arr[i]=-1;
            }
        }
        
        int maxLen = 0;
        int sum=0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        for(int i=0; i<n; i++){
            sum = sum + arr[i];
            
            if(sum == 0){
                maxLen = Math.max(maxLen, i+1);
            }
            
            if(hashMap.get(sum)!=null){
                maxLen = Math.max(i - hashMap.get(sum), maxLen);
            }
            
            if(hashMap.get(sum)==null){
                hashMap.put(sum, i);
            }
        }
        return maxLen;
    }
}