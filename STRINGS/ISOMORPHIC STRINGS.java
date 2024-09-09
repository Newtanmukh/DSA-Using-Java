class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hashMap1 = new HashMap<>();
        HashMap<Character, Character> hashMap2 = new HashMap<>();

        if(s.length() != t.length())
            return false;

        int len = s.length();

        for(int i=0; i<len; i++){
            Character x = s.charAt(i);
            Character y = t.charAt(i);
            Character first = hashMap1.get(x);
            Character second = hashMap2.get(y);

           if(first == null && second == null){//mapping do not exist till now, so put it and continue.
                hashMap1.put(x, y);//akso if one is null and second isnt null, then it will go below and also it means there is some gadbad.
                hashMap2.put(y, x);
                continue;
           }

            if(first!=y || second!=x)
                return false;
        }

        return true;

    }
}