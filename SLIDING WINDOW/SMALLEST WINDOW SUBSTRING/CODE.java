public int findSubString( String s) {
        HashSet<Character> hashSet = new HashSet<>();
        Integer n = s.length();
        
        for(Integer i=0; i<n; i++){
            hashSet.add(s.charAt(i));
        }
        
        Integer uniqueSize = hashSet.size();
        
        Integer len = Integer.MAX_VALUE;
        Integer i = 0;
        Integer j = 0;
        
        HashMap<Character, Integer> hashMap = new HashMap<>();
        
        while(j < n){
            Character lastChar = s.charAt(j);
            hashMap.put(lastChar, hashMap.getOrDefault(lastChar, 0) + 1);
            
            
            while(hashMap.size() == uniqueSize){
                
                len = Math.min(len, j-i+1);
                
                Character firstChar = s.charAt(i);
                hashMap.put(firstChar, hashMap.get(firstChar) - 1);
                
                if(hashMap.get(firstChar)==0){
                    hashMap.remove(firstChar);
                }
                
                i++;
            }
            
            j++;
        }
        return len;
    }