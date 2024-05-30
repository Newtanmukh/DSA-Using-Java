class Solution {
    static int maxSumLis(int arr[], int n) {
        int[] dp = new int[n];
        int[] numbers = new int[n];
        
        int actualSum = 0;
        
        for(int i=0; i<n; i++){
            actualSum = actualSum + arr[i];
        }
        
        Arrays.fill(dp, 1);
        Arrays.fill(numbers, -1);
        
        int ans = dp[0];
        for(int i=1; i<n; i++)
            for(int j=0; j<i; j++){
                if( (arr[i] > arr[j]) && (dp[j]+1 >= dp[i])){
                    dp[i] = dp[j] + 1;
                    numbers[i] = j;
            }
            ans = Math.max(ans, dp[i]);
        }
        
        int sum = 0;
        for(int i=0; i<n; i++){
            if(dp[i]==ans){
                sum = arr[i];
                int index = numbers[i];
                while(true){
                    if(index==-1){
                        break;
                    }
                    
                    sum = sum + arr[index];
                    index = numbers[index];
                }
            }
        }
        
        return actualSum - sum;
        
    }
}