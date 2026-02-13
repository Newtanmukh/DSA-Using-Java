

 import java.util.*;

//problem desc: https://leetcode.com/problems/longest-balanced-substring-ii/?envType=daily-question&envId=2026-02-13

class Solution {

    public int longestBalanced(String s) {
        char[] ch = s.toCharArray();
        int one = Math.max(calc1(ch, 'a'), Math.max(calc1(ch, 'b'), calc1(ch, 'c')));
        int two = Math.max(calc2(ch, 'a', 'b'), Math.max(calc2(ch, 'a', 'c'), calc2(ch, 'b', 'c')));
        int three = calc3(ch);

        return Math.max(one, Math.max(two, three));
    }

    private int calc1(char[] s, char a){
        int ans = 0;
        int i = 0;
        int n = s.length;
        int count = 0;
        int max = 0;
        while(i < n){

            if(s[i]==a){
                while(i<n && s[i]==a){
                    count++;
                    i++;
                }
                max = Math.max(max, count);
                i--;
            }

            count = 0;
            i++;
        }
        return max;
    }

    private int calc2(char[] s, char a, char b){

        int ans = 0;
        int i = 0;
        int n = s.length;

        while(i < n){
            if(s[i]!=a && s[i]!=b){
                i++;
                continue;
            }

            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            int j = i;
            while(i<n && (s[i]==a || s[i]==b)){
                sum += (s[i]==a) ? 1 : -1;

                if(sum==0){
                    ans = Math.max(ans, (i-j+1));
                }

                if(map.containsKey(sum)){
                    ans = Math.max(ans, i-map.get(sum));
                } else{
                    map.put(sum, i);
                }
                i++;
            }
        }
        return ans;
    }

    private int calc3(char[] ch){

        Map<String, Integer> map = new HashMap<>();
        map.put("0#0", -1);

        int[] freq = new int[3];
        Arrays.fill(freq, 0);
        int ans = 0;
        int n = ch.length;
        int j=0;

        while(j < n){
            char c = ch[j];
            int idx = c - 'a';
            freq[idx]++;
            int x = freq[0] - freq[1];
            int y = freq[0] - freq[2];

            String res = x + "#" + y;

            if(map.containsKey(res)){
                ans = Math.max(ans, j - map.get(res));
            }else{
                map.put(res, j);
            }
            j++;
        }

        return ans;
    }
}
