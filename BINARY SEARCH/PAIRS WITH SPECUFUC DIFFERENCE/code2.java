// User function Template for Java

import java.util.Arrays;

class code2 {
    public int maxSumPairWithDifferenceLessThanK(int arr[], int N, int k) {

        Arrays.sort(arr);
        int sum = 0;

        for(int i=arr.length-1; i>=0; i--){
            if(i-1>=0 && arr[i] - arr[i-1]<k){
                sum = sum + arr[i] + arr[i-1];
                i--;
            }
        }

        return sum;
    }

    public int getNotVisitedArray(boolean[] visited, int[] arr, int from, int to){
        for(int i=to; i>=from; i--){
            if(!visited[i]){
                visited[i] = true;
                return arr[i];
            }
        }
        return -1;
    }

    //nums[i] - k <  nums[j]
    //This will return the element just getter than nums[i] - k
    public int getLowerIndex(int[] arr,  int num){
        int low = 0;
        int high = arr.length - 1;

        int ans = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] > num){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
}
