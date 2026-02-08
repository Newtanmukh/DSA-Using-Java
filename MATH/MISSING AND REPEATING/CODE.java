//problem desc.:
class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        long s2 = 0;
        long n = (long)arr.length;

        for(int a: arr){
            long x = (long)a;
            s1 = s1 + x;
            s2 = s2 + x*x;
        }

        s2 = s2 - (long)( (n*(n+1)*(2*n+1)) / 6);
        s1 = s1 - (long)( (n * (n+1))/2);

        long temp = s2/s1;

        int[] dp = new int[2];

        /*
            2X, Y
            X - Y = s1
            X + Y = temp
            X = (s1+temp)/2;
        */

        dp[0] = (int)(s1 + temp)/2;
        dp[1] = (int)(temp - s1)/2;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(dp[0]);
        list.add(dp[1]);
        return list;
    }
}
