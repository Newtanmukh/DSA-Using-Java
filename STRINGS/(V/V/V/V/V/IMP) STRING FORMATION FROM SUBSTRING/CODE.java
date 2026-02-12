

// User function Template for Java
//problem desc: https://www.geeksforgeeks.org/problems/string-formation-from-substring2734/1
class CODE {
    int isRepeat(String s) {
        // code here
        int n = s.length();

        for(int i=1; 2*i<=n; i++){
            boolean flag = true;

            if(n%i!=0)
                continue;

            String subString = s.substring(0, i);

            for(int j=1; j<n/i; j++){
                if(!subString.equals(s.substring(i*j, i*j+i))){
                    flag = false;
                    break;
                }
            }

            if(flag)
                return 1;
        }

        return 0;
    }
}