

//problem desc: https://www.geeksforgeeks.org/problems/split-the-binary-string-into-substrings-with-equal-number-of-0s-and-1s/1
// User function Template for Java

class Solution {
    public static int maxSubStr(String s) {
        // Write your code here
        char[] ch = s.toCharArray();

        int ones = 0;
        int cnt = 0;

        for(char c: ch){
            if(c=='1')
                ones++;
            else
                ones--;

            cnt += (ones==0) ? 1 : 0;
        }

        if(ones!=0)
            return -1;

        return cnt;
    }
}