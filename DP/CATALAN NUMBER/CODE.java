class Solution {
    Long dyckPaths(int N) {
        // code here
        //(2n-1) C (n-1)

        return nCr(2*N, N)/(N+1);
    }

    public long nCr(int n, int r){
        if(r>n)
            return 0;

        r = Math.min(r, n-r);

        long res = 1L;

        for(int i=1; i<=r; i++){
            res = res * (n-i+1);
            res = res / i;
        }

        return res;
    }
};