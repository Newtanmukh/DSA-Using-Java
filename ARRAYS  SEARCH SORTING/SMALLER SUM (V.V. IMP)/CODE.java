https://www.geeksforgeeks.org/problems/smaller-sum--170647/0


class Solution
{
    public long[] smallerSum(int n,int arr[])
    {
       long[] sumArray = new long[n];
       Arrays.fill(sumArray, 0L);
       
       int[] sortedArrayCopy = new int[n];
       
       for(int i=0; i<n; i++){
           sortedArrayCopy[i] = arr[i];
       }
       
       Arrays.sort(sortedArrayCopy);
       
       for(int i=1; i<n; i++){
           sumArray[i] = sumArray[i-1] + sortedArrayCopy[i-1];
       }
       
       
       long[] ans = new long[n];
       
       for(int i=0; i<n; i++){
           int minIndex = binarySearch(arr[i], sortedArrayCopy);
           if(minIndex!=-1){
               ans[i] = sumArray[minIndex];
               continue;
           }
           ans[i] = 0;
       }
       
       return ans;
       
    }
    
    public int binarySearch(int target, int[] arr){
        int low = 0;
        int high = arr.length - 1;
        
        int index = -1;
        
        while(low<=high){
            int mid = low + (high - low)/2;
            
            if(arr[mid] == target){
                index = mid;
                high = mid - 1;
            }
            else if(arr[mid]<target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        return index;
        
    }
}