//problem desc. : https://www.geeksforgeeks.org/problems/bubble-sort/1

class Solution {
    public void bubbleSort(int[] arr) {

        for(int i = 0; i < arr.length;i++){
            for(int j = i;j < arr.length;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }
}