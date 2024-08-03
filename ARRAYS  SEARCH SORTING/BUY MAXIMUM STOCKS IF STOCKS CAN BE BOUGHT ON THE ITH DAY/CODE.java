class Solution {
    
    class Pair{
        int price;
        int maxQuantity;
        
        Pair(int price, int quantity){
            this.price = price;
            this.maxQuantity = quantity;
        }
    }
    
    
    public int buyMaximumProducts(int n, int k, int[] prices) {
        //The logic is that if we want to maximize the number of products,
        //we need to prefer the lower priced stocks over higher priced stocks.
        
        ArrayList<Pair> pairs = new ArrayList<>();
        for(int i=0; i<n; i++){
            pairs.add(new Pair(prices[i], i+1));
        }
        
        Collections.sort(pairs, new Comparator<Pair>(){
            @Override
            public int compare(Pair o1, Pair o2){
                return o1.price - o2.price;
            }
        });
        
        int count = 0;
        for(Pair pair: pairs){
            int price = pair.price;
            int maxQuantity = pair.maxQuantity;
            
            int buyable = k/price;
            
            if(buyable > 0){
                if(buyable>maxQuantity){
                    count = count + maxQuantity;
                    k = k - maxQuantity*price;
                }else{
                     count = count + buyable;
                    k = k - buyable*price;
                }
            }
        }
        
        return count;
        
    }
}