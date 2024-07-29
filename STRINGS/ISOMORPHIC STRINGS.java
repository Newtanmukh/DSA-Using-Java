 if (str1.length() != str2.length()) {
            return false;
        }
        
        // Create two hash maps to store mappings from str1 to str2 and vice versa
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        
        for (int i = 0; i < str1.length(); i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);
            
            // Check if there is an existing mapping in map1
            if (map1.containsKey(char1)) {
                // If the current mapping does not match char2, return false
                if (map1.get(char1) != char2) {
                    return false;
                }
            } else {
                // If no mapping exists, create a new mapping
                map1.put(char1, char2);
            }
            
            // Check if there is an existing mapping in map2
            if (map2.containsKey(char2)) {
                // If the current mapping does not match char1, return false
                if (map2.get(char2) != char1) {
                    return false;
                }
            } else {
                // If no mapping exists, create a new mapping
                map2.put(char2, char1);
            }
        }
        
        // If all characters are consistently mapped, the strings are isomorphic
        return true;