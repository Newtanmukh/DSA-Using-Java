class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int k) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        
        for(int i=0; i<n; i++){
            if(hashMap.getOrDefault(k - arr[i], false)){
                return true;
            }
            
            hashMap.put(arr[i], true);
        }
        
        return false;
    }
}