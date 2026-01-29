// https://www.geeksforgeeks.org/problems/generate-all-possible-parentheses/1

class Solution {

    ArrayList<String> ans;

    void dfs(String s, int left, int right, int n){

        if(left + right > n){
            return;
        }

        if(left==right && s.length()==n){
            ans.add(new String(s));
            return;
        }

        if(left < n){
            dfs(s + "(", left + 1, right, n);
        }

        if(right < left){
            dfs(s + ")", left, right + 1, n);
        }
    }

    public ArrayList<String> generateParentheses(int n) {
        // code here
        ans = new ArrayList<>();

        dfs("", 0, 0, n);

        return ans;
    }
}