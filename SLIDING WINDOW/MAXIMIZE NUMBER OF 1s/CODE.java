class Solve {
    // m is maximum of number zeroes allowed to flip
    int findZeroes(int arr[], int n, int m) {
        int maxLength = 0;
        int numZeroes = 0;
        int start = 0;
        int end = 0;
        
        if(n==m)
            return n;
            
        while(end < n){
            if(arr[end]==0){
                numZeroes++;
            }
            
            while(numZeroes>m){
                if(arr[start]==0){
                    numZeroes--;
                }
                start++;
            }
         
         maxLength = Math.max(maxLength, end-start+1);   
         end++;
        }
        
        return maxLength;
            
        
    }
}