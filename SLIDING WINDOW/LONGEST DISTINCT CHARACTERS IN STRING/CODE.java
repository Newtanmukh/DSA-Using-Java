class Solution{
    static int longestSubstrDistinctChars(String str){
        int i = 0;
        int j = 0;
        
        int ans = Integer.MIN_VALUE;
        int n = str.length();
        
        HashMap<Character, Integer> hashMap = new HashMap<>();
        
        while(j<n){
            Character lastChar = str.charAt(j);
            hashMap.put(lastChar, hashMap.getOrDefault(lastChar, 0) + 1);
            
            while(hashMap.get(lastChar)>1){
                Character firstChar = str.charAt(i);
                hashMap.put(firstChar, hashMap.get(firstChar)-1);
                
                if(hashMap.get(firstChar)==0){
                    hashMap.remove(firstChar);
                }
                i++;
            }
            
            ans = Math.max(ans, j-i+1);
            j++;
        }
        
        return ans;
        
    }
}