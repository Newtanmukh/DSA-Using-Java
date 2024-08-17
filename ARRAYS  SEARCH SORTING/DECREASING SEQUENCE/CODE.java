class Compute {
        long k;
        long mod = (long)1e9+7;
    public long minMoves(long a[], long n, long k) {
       long num = 0;
       this.k=k;
       for(int i=1; i<n; i++){
           if(a[i-1]<a[i]){
               long count = cnt(a[i-1], a[i]);
               a[i] = a[i] - count*k;
               num = num + count;
           }
       }
       
       return num%mod;
    }
    
    public long cnt(long small, long big){
        long diff = big - small;
        if(diff%k==0){
            return diff/k;
        }else{
            return (diff/k)+1;
        }
    }
}