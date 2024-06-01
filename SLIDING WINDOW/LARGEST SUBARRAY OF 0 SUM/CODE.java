class GfG
{
    int maxLen(int arr[], int n)
    {
         
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