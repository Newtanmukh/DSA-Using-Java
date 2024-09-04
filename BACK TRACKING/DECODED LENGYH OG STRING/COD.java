class Solution {
    public String decodeAtIndex(String s, int k) {
         long decodedLength = 0;

         for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                decodedLength = decodedLength * (c - '0');
            }else{
                decodedLength = decodedLength + 1; 
            }
         }

        k %= decodedLength;

         for(int i=s.length()-1; i>=0; i--){
            char currentChar = s.charAt(i);
            if(Character.isDigit(currentChar)){
                decodedLength = decodedLength/(currentChar - '0');
                k %= decodedLength;
            }else{
                if(k==0 || k==decodedLength)
                    return String.valueOf(currentChar);

                decodedLength--;
            }
         }

         return "";
    }
}
