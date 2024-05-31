class Compute {
    
    public long[] printFirstNegativeInteger(long arr[], int n, int k){
        Deque<Integer> deque = new ArrayDeque<Integer>();
        
        List<Long> list = new ArrayList<>();
        
        for(int i=0; i<k; i++){
            if(arr[i]<0L){
                if(list.size()==0){
                    list.add(arr[i]);
                }
                deque.addLast(i);
            }
        }
        
        if(deque.size()==0){
            list.add(0L);
        }
        
        for(int i=k; i<n; i++){
            if(arr[i] < 0L){
                deque.addLast(i);
            }
            
            if(deque.size()==0){
                list.add(0L);
            }else{
                
                while(deque.size() > 0 && deque.peekFirst() < i-k+1){
                    deque.removeFirst();
                }
                
                if(deque.size()>0){
                    list.add(arr[deque.peekFirst()]);
                }else{
                    list.add(0L);
                }
            }
        }
        
        long[] array = new long[list.size()]; 
        
        for(int i=0; i<list.size(); i++){
            array[i] = list.get(i);
        }
        
        return array;
        
    }
}