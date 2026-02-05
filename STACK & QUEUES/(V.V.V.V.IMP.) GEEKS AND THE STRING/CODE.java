//problem desc: https://www.geeksforgeeks.org/problems/geeks-and-the-string--170645/1
class Solution {
    public static String removePair(String s) {
        // code here
        Stack<Character> stack = new Stack<>();

        char[] ch = s.toCharArray();

        for(char c: ch){
            int cnt = 0;
            while(!stack.isEmpty() && c==stack.peek()){
                stack.pop();
                cnt++;
            }

            if(cnt==0 || cnt%2==0){
                stack.push(c);
            }
        }

        if(stack.size()==0)
            return "-1";

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.peek());
            stack.pop();
        }

        return sb.reverse().toString();
    }
}
