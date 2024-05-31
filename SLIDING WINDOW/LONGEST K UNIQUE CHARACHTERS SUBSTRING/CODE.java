class Solution {
    public int longestkSubstr(String s, int k) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        Integer i = 0;
        Integer j = 0;
        Integer n = s.length();
        Integer len = -1;
        
        while(j < n){
            Character lastChar = s.charAt(j);
            hashMap.put(lastChar, hashMap.getOrDefault(lastChar, 0) + 1);
            
            while(hashMap.size()>k){
                Character firstChar = s.charAt(i);
                hashMap.put(firstChar, hashMap.get(firstChar) - 1);
                
                if(hashMap.get(firstChar)==0){
                    hashMap.remove(firstChar);
                }
                i++;
            }
            
            if(hashMap.size()==k){
                len = Math.max(len, j-i+1);
            }
            
            j++;
        }
        
        return len;
        
    }
}