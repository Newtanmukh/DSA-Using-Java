class Solution {
    static int makeProductOne(int[] arr, int n) {
        int totalSteps = 0;
        
        int smallestNegativeNum = Integer.MIN_VALUE;
        int numNegative = 0;
        int numZeroes = 0;
        
        for(int i=0; i<n; i++){
            if(arr[i]<0){
                smallestNegativeNum = Math.max(smallestNegativeNum, arr[i]);
                numNegative++;
                totalSteps = totalSteps - 1 - arr[i];
            }else{
                if(arr[i]==0){
                    numZeroes++;
                }else{
                    totalSteps = totalSteps + arr[i] - 1;
                }
            }
        }
        
        if(numNegative%2==0){
            return totalSteps + numZeroes;
        }else{
            if(numZeroes==0){
                return totalSteps + 2;
            }else{
                
                totalSteps = totalSteps + numZeroes - 1; // make one zero to negative 1, that will compensate for the negative element which is already negative 
                totalSteps = 1 + totalSteps;//make rest of the zeroes to 1.
                return totalSteps;
            }
        }
    }
};