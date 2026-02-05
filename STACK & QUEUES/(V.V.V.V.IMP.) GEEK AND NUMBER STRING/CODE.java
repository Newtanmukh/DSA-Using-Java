// User function Template for Java
//problem desc: https://www.geeksforgeeks.org/problems/geek-and-number-string--141631/1
class Solution {
    public int minLength(String s, int n) {
        // code here
        char[] ch = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        Map<String, Integer> map = new HashMap<>();

        map.put("12", 0);
        map.put("21", 0);
        map.put("34", 0);
        map.put("43", 0);
        map.put("56", 0);
        map.put("65", 0);
        map.put("78", 0);
        map.put("87", 0);
        map.put("09", 0);
        map.put("90", 0);

        for(char c: ch){
            if(!stack.isEmpty()){
                String res = stack.peek() + "" + c;
                if(map.containsKey(res)){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }else{
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        // while(stack.size()>0){
        //     sb.append(stack.peek());
        //     stack.pop();
        // }

        // return sb.reverse().toString();
        return stack.size();
    }
}