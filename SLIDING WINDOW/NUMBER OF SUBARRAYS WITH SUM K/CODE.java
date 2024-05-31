class Solution
{
    static int findSubArraySum(int arr[], int n, int k)
    {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        Integer sum = 0;
        Integer count = 0;
        hashMap.put(0, 1);
        
        for(Integer i=0; i<n; i++){
            sum = sum + arr[i];
            
            if(hashMap.get(sum-k)!=null){
                count = count + hashMap.get(sum-k);
            }
            
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}