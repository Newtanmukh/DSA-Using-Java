class Solution {
    static String maxSum(String w, char x[], int b[], int n) {
        // code here

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            map.put(x[i], b[i]);
        }

        int[] arr = new int[w.length()];

        for(int i=0; i<arr.length; i++){
            arr[i] = map.containsKey(w.charAt(i)) ? map.get(w.charAt(i)) : (int)(w.charAt(i));
        }

        //this will store the length upto index 'i'.
        int[] dp = new int[w.length()];

        //this will store the index of the subarray max subarray ending at this index.
        int[] indexes = new int[w.length()];

        dp[0] = arr[0];
        indexes[0] = 0;
        int ans = dp[0];
        for(int i=1; i<dp.length; i++){
            // dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);

            if(dp[i-1] + arr[i] > arr[i]){
                dp[i] = dp[i-1] + arr[i];
                indexes[i] = indexes[i-1];
            }else {
                dp[i] = arr[i];
                indexes[i] = i;
            }
            ans = Math.max(ans, dp[i]);
        }

        for(int i=0; i<dp.length; i++){
            if(ans == dp[i]){
                return w.substring(indexes[i], i+1);
            }
        }

        return "";
    }
}