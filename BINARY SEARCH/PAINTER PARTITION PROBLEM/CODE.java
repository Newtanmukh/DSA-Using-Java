

//problem desc : https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1
class CODE {
    public int minTime(int[] arr, int k) {
        // code here
        int sum = 0;
        for(int i: arr)
            sum += i;

        return binarySearch(sum, arr, k);
    }

    public int binarySearch(int sum, int[] arr, int k){
        int req = 0;
        int low = 1;
        int high = sum;
        int ans = high;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(!isReachableInK(mid, arr, k)){
                low = mid + 1;
            }else{
                ans = Math.min(ans, mid);
                high = mid - 1;
            }
        }

        return ans;
    }

    public boolean isReachableInK(int time, int[] arr, int k){
        int req = 1;
        int ok = time;
        for(int i=arr.length-1; i>=0; i--){
            if(ok>=arr[i]){
                ok = ok - arr[i];
            }else{
                ok = time;
                if(ok<arr[i])
                    return false;
                req++;
                ok = ok - arr[i];
            }
        }

        return req<=k;
    }
}
