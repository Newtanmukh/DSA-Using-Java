class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    
    long binarySearch(double target, double[] search, int left, int right){
        int n = search.length;
        
        long index = -1;
        
        while(left<=right){
            int mid = left + (right - left)/2;
            
            if(search[mid] > target){
                index = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        if(index == -1)
            return 0;
        
        return n - index;
    }
    
    public long countPairs(int x[], int y[], int M, int N) {
        double[] first = new double[M];
        double[] second = new double[N];
        
        for(int i=0; i<M; i++){
            first[i] = (double)(Math.log(x[i])/x[i]);
        }
        
        for(int i=0; i<N; i++){
            second[i] = (double)(Math.log(y[i])/y[i]);
        }
        
        Arrays.sort(first);
        Arrays.sort(second);
        
        long count = 0;
        
        for(int i=0; i<N; i++){
            count = count + binarySearch(second[i], first, 0, M-1);
        }
        
        return count;
        
    }
}