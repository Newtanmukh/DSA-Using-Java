

//problem desc: https://www.geeksforgeeks.org/problems/isomorphic-strings-1587115620/1


import java.util.HashMap;
import java.util.Map;

class CODE   {
    public boolean areIsomorphic(String s1, String s2) {
        // code here
        if(s1.length() != s2.length())
            return false;

        Map<Character, Character> s1Tos2Map = new HashMap<>();
        Map<Character, Character> s2Tos1Map = new HashMap<>();

        int n = s1.length();

        for(int i=0; i<n; i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if(s1Tos2Map.containsKey(c1)){
                if(s1Tos2Map.get(c1)!=c2)
                    return false;
            } else{
                s1Tos2Map.put(c1, c2);
            }

            if(s2Tos1Map.containsKey(c2)){
                if(s2Tos1Map.get(c2)!=c1){
                    return false;
                }
            }else{
                s2Tos1Map.put(c2, c1);
            }
        }

        return true;
    }
}