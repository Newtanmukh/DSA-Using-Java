//problem : https://www.geeksforgeeks.org/problems/max-sum-in-the-configuration/1
class Solution {
    int maxSum(int[] arr) {
        // code here

        int sum = 0;
        int totalSum = 0;
        int n = arr.length;
        for(int i=0; i<arr.length; i++){
            sum = sum + i*arr[i];
            totalSum += arr[i];
        }

        //
        int maxSum = sum;

        for(int i=0; i<arr.length; i++){
            sum = sum - totalSum;
            sum = sum + (n) * arr[i];
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;

    }
}