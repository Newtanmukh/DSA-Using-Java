public int findSubString( String s) {
      HashSet<Character> uniqueCharsSet = new HashSet<>();
        int n = s.length();
        
        // Step 1: Identify all unique characters in the string
        for (int i = 0; i < n; i++) {
            uniqueCharsSet.add(s.charAt(i));
        }
        
        int uniqueSize = uniqueCharsSet.size();
        int minLength = Integer.MAX_VALUE;
        
        int left = 0;
        int right = 0;
        
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        

        while (right < n) {
            char rightChar = s.charAt(right);
            charCountMap.put(rightChar, charCountMap.getOrDefault(rightChar, 0) + 1);
            
          
            while (charCountMap.size() == uniqueSize) {
                minLength = Math.min(minLength, right - left + 1);
                
                char leftChar = s.charAt(left);
                if (charCountMap.get(leftChar) == 1) {
                    charCountMap.remove(leftChar);
                } else {
                    charCountMap.put(leftChar, charCountMap.get(leftChar) - 1);
                }
                
                left++;
            }
            
            right++;
        }
        
        return minLength;
    }