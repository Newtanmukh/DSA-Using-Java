

//problem desc: https://www.geeksforgeeks.org/problems/longest-palindrome-in-a-string1956/1

class CODE {
    public String getLongestPal(String s) {
        // code here
        char[] ch = s.toCharArray();
        int max = 1;
        int n = ch.length;
        int l = 0;
        int r = 0;
        int start = 0;

        for(int i=0; i<n; i++){
            l = i-1;
            r = i;

            while(l>=0 && r<n && ch[l]==ch[r]){
                if(r-l+1>max){
                    start = l;
                    max = r-l+1;
                }
                l--;
                r++;
            }

            r = i+1;
            l = i-1;

            while(l>=0 && r<n && ch[l]==ch[r]){
                if(r-l+1>max){
                    start = l;
                    max = r-l+1;
                }
                l--;
                r++;
            }
        }

        return s.substring(start, start+max);
    }
}