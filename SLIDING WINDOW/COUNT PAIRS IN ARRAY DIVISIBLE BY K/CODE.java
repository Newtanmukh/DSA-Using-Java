class Solution
{
    public static long countKdivPairs(int arr[], int n, int k)
    {
        long count = 0;
        HashMap<Integer, Long> hashMap = new HashMap<>();
        
            
        for (int i = 0; i < n; i++) {
            int remainder = arr[i] % k;
            
            if(remainder==0){
                count = count + hashMap.getOrDefault(0, 0L);        
            }else{
                count = count + hashMap.getOrDefault(k-remainder, 0L);
            }
            
            hashMap.put(remainder, hashMap.getOrDefault(remainder, 0L) + 1);
        }
        
        return count;
    }
}