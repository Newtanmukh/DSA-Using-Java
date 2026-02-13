
//problem desc: https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
import java.util.*;

class Solution {

    List<String> list;

    public void dfs(int len, int n, String s, char c){
        if(len==n){
            list.add(s);
            return;
        }

        if(c=='%'){
            dfs(len+1, n, s+"a", 'a');
            dfs(len+1, n, s+"b", 'b');
            dfs(len+1, n, s+"c", 'c');
        }else if(c=='a'){
            dfs(len+1, n, s+"b", 'b');
            dfs(len+1, n, s+"c", 'c');
        }else if(c=='b'){
            dfs(len+1, n, s+"a", 'a');
            dfs(len+1, n, s+"c", 'c');
        }else if(c=='c'){
            dfs(len+1, n, s+"a", 'a');
            dfs(len+1, n, s+"b", 'b');
        }
    }

    public String getHappyString(int n, int k) {
        list = new ArrayList<>();

        dfs(0, n, "", '%');
        if(list.size()>=k)
            return list.get(k-1);
        return "";
    }
}