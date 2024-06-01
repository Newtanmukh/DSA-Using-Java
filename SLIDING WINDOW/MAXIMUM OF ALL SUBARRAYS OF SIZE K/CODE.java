class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {

       ArrayList<Integer> list = new ArrayList<Integer>();
       Deque<Integer> dq = new ArrayDeque<Integer>();
       
       for(Integer i=0; i<n; i++){
           
           while(dq.size() > 0 && dq.peekFirst() < i-k+1){
               dq.removeFirst();
           }
           
           while(dq.size() > 0 && arr[dq.peekLast()] <= arr[i]){
               dq.removeLast();
           }
           
           dq.addLast(i);
           
           if(i >= k-1){
               list.add(arr[dq.peekFirst()]);
           }
       }
       
       return list;
       
    }
}