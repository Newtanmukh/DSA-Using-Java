class Solution{
    
    boolean[] isPrime = new boolean[1000001];
    
    public void sieveOfErathneses(){
        
        Arrays.fill(isPrime, true);
        
        for(int i=2; i*i<=1000000; i++){
            if(isPrime[i]){
                for(int j=i*i; j<=1000000; j= j+i){
                    isPrime[j] = false;
                }
            }
        }
    }
    
    int anss(long k){
        int ans = 0;
        for(int i=2; i*i<=k; i++){
            if(isPrime[i] && Math.pow(i, 2)<=k){
                ans++;
            }
        }
        
        return ans;
    }
    
     ArrayList<Integer> threeDivisors(ArrayList<Long> querys, int q){
        sieveOfErathneses();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<q; i++){
            long query = querys.get(i);
            int count = anss(query);
            list.add(count);
        }
        
        return list;
    }
}
