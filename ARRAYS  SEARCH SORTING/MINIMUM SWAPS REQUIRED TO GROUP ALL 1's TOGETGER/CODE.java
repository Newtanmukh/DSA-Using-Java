class Complete {

    // Function for finding maximum and value pair
    public static int minSwaps(int arr[], int n) {
        /**
            O(n^2) algorithm : find the number of 1's in the array. call it numOnes;
            
            Then, do a sliding window of numOnes and calculate the number of ones in the window
            the sliding window having the largest number of 1,  we need to just remove the 0's frpm there/
        **/
        
        int numOnes = 0;
        
        for(int num: arr){
            numOnes = numOnes + num;
        }
        
        if (numOnes == 0) {
        return -1;
    }
    
        if (numOnes == n) {
        return 0;
    }
        
        
        int ones = 0;
        
        for(int i=0; i<numOnes; i++){
            ones = ones + arr[i];
        }
        
        int minSwaps = numOnes - ones;
        
        for(int i=numOnes; i<n; i++){
            ones = ones + arr[i];
            ones = ones - arr[i-numOnes];
            
            minSwaps = Math.min(minSwaps, numOnes - ones);
        }
        
        return minSwaps;
        
    }
}