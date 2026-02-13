

 import java.util.*;
//problem desc: https://leetcode.com/problems/longest-balanced-substring-ii/?envType=daily-question&envId=2026-02-13

//import java.util.Map;


 /***In the below question, IT WILL GIVE YOU THE LONGEST SUBSTRING WITH EQUAL NUMBER
  * OF A, B and C ALL THREE.
  *
  * NOT LIKE, ONLY A & B or,
  * ONLY B & C, etc.
  * ***/
class CODE {
    public int longestBalanced(String s) {
        Map<String, Integer> map = new HashMap<>();

        int a = 0, b = 0, c = 0;
        int max = 0;

        // base case: before starting
        map.put("0#0", -1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'a') a++;
            else if (ch == 'b') b++;
            else c++;

            int d1 = a - b;
            int d2 = a - c;

            String key = d1 + "#" + d2;

            if (map.containsKey(key)) {
                max = Math.max(max, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }

        return max;
    }
}

