
//problem desc. : https://leetcode.com/problems/longest-balanced-substring-i/?envType=daily-question&envId=2026-02-12
class CODE {
    public int longestBalanced(String s) {
        int max = 0;
        int n = s.length();

        for(int i=0; i<n; i++){
            int[] freq = new int[26];

            Arrays.fill(freq, 0);

            for(int j=i; j<n; j++){
                char c = s.charAt(j);
                int idx = c - 'a';
                freq[idx]++;

                if(isSameFreq(freq)){
                    max = Math.max(max, j-i+1);
                }
            }
        }

        return max;
    }

    private boolean isSameFreq(int[] freq){
        int val = 0;

        for(int a: freq){
            if(a==0)
                continue;

            if(val==0){
                val = a;
            }else if(val!=a){
                return false;
            }
        }

        return true;
    }
}