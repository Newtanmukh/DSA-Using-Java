class Solution
{ 
   // Method to calculate distinct sub-array 
    static int countDistinctSubarray(int arr[], int n) 
    { 
       HashSet<Integer> set = new HashSet<>();
       
       for(Integer i=0; i<n; i++){
            set.add(arr[i]);    
       }
       
       Integer k = set.size();
       
       Integer i = 0;
       Integer j = 0;
       Integer count = 0;
       
       HashMap<Integer, Integer> hashMap = new HashMap<>();
       
       while(j < n){
           
           hashMap.put(arr[j], hashMap.getOrDefault(arr[j], 0) + 1);
           
           while(hashMap.size()==k){
               count = count + n-j;
               
               if(hashMap.get(arr[i])!=null){
                   hashMap.put(arr[i], hashMap.get(arr[i]) - 1);
               }
               
               if(hashMap.get(arr[i])==0){
                   hashMap.remove(arr[i]);
               }
               i++;
           }
           j++;
       }
       
       return count;
       
       
    }
}