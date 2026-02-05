

// User function Template for Java
//problem desc: https://www.geeksforgeeks.org/problems/license-key-formatting/1
class Solution {
    static String ReFormatString(String s, int k) {
        // code here
        Stack<Character> stack = new Stack<>();

        char[] ch = s.toCharArray();

        for(char c: ch){
            if(c!='-'){
                if(c>='a' && c<='z')
                    c = (char)(c + (int)('A'-'a'));
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(true){

            for(int i=0; i<k; i++){
                if(stack.size()>0){
                    sb = sb.append(stack.pop());
                }else{
                    break;
                }
            }

            if(stack.size()>0){
                sb.append("-");
            }else{
                break;
            }
        }

        return sb.reverse().toString();

    }
}