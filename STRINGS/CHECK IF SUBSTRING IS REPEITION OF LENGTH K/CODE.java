import java.util.HashSet;

// User function Template for Java
//problem desc: https://www.geeksforgeeks.org/problems/check-if-a-string-is-repetition-of-its-substring-of-k-length3302/1
class CODE {
    int kSubstrConcat(int n, String s, int k) {
        // Your Code Here
        if(n%k!=0)
            return 0;

        if(k==n)
            return 1;

        String sub = s.substring(0, k);



        int cnt = 0;
        HashSet<String> set = new HashSet<>();
        set.add(sub);
        for(int i=k; i<n; i=i+k){
            String substring = s.substring(i, i + k);
            if(!substring.equals(sub)){
                cnt++;
            }
            set.add(substring);
        }

        if(set.size()==1)
            return 1;

        if(set.size()>2)
            return 0;

        //case 1: first is unique, then cnt = (n/k)-1
        //case 2: first is NOT unique, then cnt = 1
        if(cnt==1 || cnt==(n/k)-1)
            return 1;

        return 0;
    }
}