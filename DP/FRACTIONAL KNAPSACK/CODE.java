class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) {
        Arrays.sort(arr, new Comparator<Item>(){
            @Override
            public int compare(Item lhs, Item rhs){
                int x = lhs.value*rhs.weight - lhs.weight*rhs.value;
                
                if(x > 0)
                    return -1;
                    
                return 1;
            }
        });
        
        double value = 0;
        
        for(int i=0; i<arr.length; i++){
            if(w >= arr[i].weight){
                w = w - arr[i].weight;
                value = value + arr[i].value;
            }else{
                value = value + arr[i].value * ((double)w / (double)arr[i].weight);
                break;
            }
        }
        
        return value;
        
    }
}