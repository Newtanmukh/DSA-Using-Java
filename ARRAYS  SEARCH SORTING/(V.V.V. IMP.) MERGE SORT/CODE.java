
//problem desc: https://www.geeksforgeeks.org/problems/merge-sort/1
class Solution {

    void mergeSort(int arr[], int low, int high) {

        if(low>=high)
            return;

        int mid = low + (high - low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    void merge(int[]arr, int low, int mid, int high){
        int[] tempArray = new int[high-low+1];
        int idx = 0;

        int i = low;
        int j = mid+1;


        while(i<=mid && j<=high){
            if(arr[i]<arr[j]){
                tempArray[idx] = arr[i];
                i++;
            }else{
                tempArray[idx] = arr[j];
                j++;
            }
            idx++;
        }

        while(i<=mid){
            tempArray[idx] = arr[i];
            i++;
            idx++;
        }

        while(j<=high){
            tempArray[idx] = arr[j];
            j++;
            idx++;
        }

        for(i=0; i<tempArray.length; i++){
            arr[i+low] = tempArray[i];
        }
    }
}