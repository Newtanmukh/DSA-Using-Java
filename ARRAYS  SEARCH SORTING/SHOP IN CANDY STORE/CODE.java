// https://www.geeksforgeeks.org/problems/shop-in-candy-store1145/1


class Solution{
    static ArrayList<Integer> candyStore(int candies[],int n,int k){
        Arrays.sort(candies);
        
        int buyCount = 0;
        
        if(n%(k+1)==0){
            buyCount = (n/(k+1));    
        }else{
            buyCount = (n/(k+1)) + 1;  
        }
        
        int min_amount = 0;
        int max_amount = 0;
        
        for(int i=0; i<n; i++){
            min_amount = min_amount + candies[i];
            max_amount = max_amount + candies[n-i-1];
            
            buyCount--;
            
            if(buyCount==0){
                break;
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(min_amount);
        list.add(max_amount);
        
        return list;
        
    }
}