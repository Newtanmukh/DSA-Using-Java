import java.util.*;
//problem: https://leetcode.com/problems/replace-words/
class CODE {
    public String replaceWords(List<String> dictionary, String sentence) {

        String[] words = sentence.split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (String word : dictionary) {
            map.put(word, 1);
        }

        StringBuilder sb = new StringBuilder();

        for(String word: words){
            char[] chArr = word.toCharArray();
            String res = "";

            boolean isFound = false;

            for(char c: chArr){
                res = res + c;
                if(map.containsKey(res)){
                    sb.append(res);
                    isFound = true;
                    break;
                }
            }

            if(!isFound){
                sb.append(word);
            }
            sb.append(" ");
        }

        return sb.substring(0, sb.toString().length()-1);
    }
}