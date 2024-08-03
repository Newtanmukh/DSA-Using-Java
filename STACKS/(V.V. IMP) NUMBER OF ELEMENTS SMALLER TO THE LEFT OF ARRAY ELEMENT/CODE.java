class Solution {
    // Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n) {
       
        Deque<Integer> deque = new ArrayDeque<Integer>();
        
        int[] arr = new int[n];
        Arrays.fill(arr, 0);
        
        for(int i=0; i<n; i++){
            while(deque.size() > 0 && price[deque.peekFirst()] <= price[i]){
                deque.removeFirst();
            }
            
            if(deque.size()==0){
                arr[i] = i + 1;
            }else{
                arr[i] = i - deque.peekFirst();
            }
            
            deque.addFirst(i);//we add it at the end.
        }
        
        return arr;
        
        
    }
}