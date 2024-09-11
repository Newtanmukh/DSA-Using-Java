class Solution{
     List<Integer> nextPermutation(int N, int arr[]){
    if (N <= 1) return toList(arr);

        // Step 1: Find the first decreasing element
        int i = N - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // If no such element is found, it means the array is in descending order
        if (i >= 0) {
            // Step 2: Find the smallest element larger than arr[i]
            int j = N - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            // Swap them
            swap(arr, i, j);
        }

        // Step 3: Reverse the elements from i+1 to the end of the array
        reverse(arr, i + 1, N - 1);

        return toList(arr);
        
    }
    
     private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    
   private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    }
    
    private static List<Integer> toList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
        list.add(num);
    }
        return list;
    }
}