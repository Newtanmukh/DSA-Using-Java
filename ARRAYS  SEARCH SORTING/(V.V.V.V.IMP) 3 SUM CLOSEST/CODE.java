
// problem: https://www.geeksforgeeks.org/problems/3-sum-closest/1
class Solution {
    public int closest3Sum(int[] arr, int target) {

        Arrays.sort(arr);
        int n = arr.length;

        int ans = Integer.MIN_VALUE;
        int threshold = Integer.MAX_VALUE;

        for(int i=0; i<n-2; i++){
            int left = arr[i];

            int low = i+1;
            int high = n-1;

            while(low < high){
                int sum = left + arr[low] + arr[high];
                // if(sum==target)
                //     return sum;

                int diff = Math.abs(sum - target);
                if((diff < threshold) || (diff == threshold && sum>=ans)){
                    threshold = diff;
                    ans = sum;
                }

                if(sum>target){
                    high--;
                }else{
                    low++;
                }
            }
        }

        return ans;
    }
};