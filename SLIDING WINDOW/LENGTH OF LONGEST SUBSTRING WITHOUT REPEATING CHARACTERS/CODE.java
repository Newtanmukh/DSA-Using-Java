class Solution{
    int longestUniqueSubsttr(String s){
        int len = 1;
        int n = s.length();
        Integer i = 0;
        Integer j = 0;
        
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        
        while(j < n){ 
            Character lastChar = s.charAt(j);
            hashMap.put(lastChar, hashMap.getOrDefault(lastChar, 0) + 1);
            while(hashMap.get(s.charAt(j)) > 1){
                Character firstChar = s.charAt(i);
                Integer x = hashMap.get(firstChar);
                hashMap.put(firstChar, x-1);
                
                if(hashMap.get(firstChar)==0){
                    hashMap.remove(firstChar);
                }
                i++;
            }
            len = Math.max(len, j-i+1);
            j++;
        }
        
        return len;
        
    }
}