class Solution {

    public boolean[] isPrime = new boolean[1001];

    public void sieveOfErathones(){
        Arrays.fill(isPrime, true);

        for(int i=2; i*i<=1000; i++){
            if(isPrime[i]){
                for(int j=i*i; j<=1000; j=j+i){
                    isPrime[j] = false;
                }
            }
        }
    }

    public int minSteps(int n) {

        int ans = 0;
        
        sieveOfErathones();

        // if(isPrime[n] && n!=1)
        //     return n;

        for(int i=1000; i>=2; i--){
            if(isPrime[i] && n%i==0){
                while(n%i==0){
                    ans = ans + i;
                    n = n/i;
                }

                if(n==1)
                    break;
            }
        }


        
        return ans;
    }
}