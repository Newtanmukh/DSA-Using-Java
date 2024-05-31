class Solution {
    static int countOfSubstrings(String s, int k) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        Integer i=0;
        Integer j=0;
        
        int n = s.length();
        
        int count = 0;
        
        while(j < n){
            hashMap.put(s.charAt(j), hashMap.getOrDefault(s.charAt(j), 0) + 1);
            if(j-i+1 < k){
                j++;
            }else if(j-i+1 == k){
                if(hashMap.size()==k-1){
                    count++;
                }
                
                if(hashMap.get(s.charAt(i))!=null){
                    hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) - 1);
                }
                
                if(hashMap.get(s.charAt(i))!=null && hashMap.get(s.charAt(i))==0){
                    hashMap.remove(s.charAt(i));
                }
                i++;
                j++;
            }
        }
        
        return count;
    }
};