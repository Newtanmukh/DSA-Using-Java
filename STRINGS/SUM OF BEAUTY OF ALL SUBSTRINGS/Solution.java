import java.util.Arrays;


//problem desc: https://www.geeksforgeeks.org/problems/sum-of-beauty-of-all-substrings-1662962118/1
class Solution {
    public static int beautySum(String s) {
        // code here
        int n = s.length();

        char[] ch = s.toCharArray();
        int ans = 0;

        for(int i=0; i<n; i++){
            int[] freq = new int[26];
            Arrays.fill(freq, 0);

            for(int j=i; j<n; j++){
                int idx = ch[j] - 'a';
                freq[idx]++;

                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for(int k=0; k<26; k++){
                    if(freq[k]>0){
                        min = Math.min(min, freq[k]);
                        max = Math.max(max, freq[k]);
                    }
                }

                ans = ans + (max-min);
                // System.out.println("MAX MINUS MIN IS : " + (max-min));
            }
        }

        return ans;
    }
}
