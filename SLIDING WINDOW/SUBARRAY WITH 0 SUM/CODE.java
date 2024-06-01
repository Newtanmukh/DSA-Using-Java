static boolean findsum(int arr[],int n)
    {
        int sum = 0;
        
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        for(int i=0; i<n; i++){
            sum = sum + arr[i];
            
            if(sum==0)
                return true;
            
            if(hashMap.get(sum)!=null){
                return true;
            }
            
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        
        return false;
    }