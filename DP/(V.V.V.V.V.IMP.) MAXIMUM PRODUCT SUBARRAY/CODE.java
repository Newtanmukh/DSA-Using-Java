//problem desc:https://www.geeksforgeeks.org/problems/maximum-product-subarray3604/1

class Solution {
    int maxProduct(int[] arr) {
        //depicts the minimum of the subarray till index i.
        long minimum = arr[0];

        //depicts the maximumof subarray till index i.
        long maximum = arr[0];
        int n = arr.length;
        long ans = arr[0];

        for(int i=1; i<n; i++){
            if(arr[i]<0){
                long temp = minimum;
                minimum = maximum;
                maximum = temp;
            }

            minimum = Math.min(minimum*arr[i], arr[i]);
            maximum = Math.max(maximum*arr[i], arr[i]);

            // ans = Math.max(ans, Math.max(minimum, maximum));
            ans = Math.max(ans, maximum);
        }

        return (int)ans;
    }


}