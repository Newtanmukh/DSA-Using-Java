class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int size = weights.length;
        int minCapacity = getMinCapacity(weights);//the minimum weight among all.
        int maxCapacity = getMaxCapacity(weights);//Sum of all weight.


        int maxWeightAmongAllWeights = minCapacity;
        int minCapacityOfShipRequired = maxCapacity;

        while(minCapacity <= maxCapacity){
           int midWeight = minCapacity + (maxCapacity - minCapacity)/2;

           if(midWeight < maxWeightAmongAllWeights){//basically the weight we are considering is smaller than the max Weight of all weights. in this case, we just increment the lower bound.
                minCapacity = midWeight + 1;
           }else 
           if(canShipInDdays(days, weights, midWeight)){
                minCapacityOfShipRequired = Math.min(midWeight, minCapacityOfShipRequired);
                maxCapacity = midWeight;
           }else{
                minCapacity = midWeight + 1;
           }

           if(minCapacity==maxCapacity)//otherwise the loop will keep going on
            break;
        }

        return minCapacityOfShipRequired;
        
    }

    public boolean canShipInDdays(int days, int[] weight, int maxWeightOfShip){
        int numOfDays = 1;
        int totWt = 0;

        for(int w  :  weight){
            if(w>maxWeightOfShip)
                return false;

            if(totWt + w > maxWeightOfShip){
                numOfDays++;//basically , the ship cant onboard any more luggage. so send the ship ahead, and when the ship comesback empty, again start onloading.
                totWt = 0;
            }
            totWt = totWt + w;
        }

        return numOfDays <= days;

    }

    public int getMaxCapacity(int[] weights){
        int sum = 0;

        for(int weight: weights){
            sum = sum + weight;
        }
        return sum;
    }

    public int getMinCapacity(int[] weights){
        int sum = Integer.MIN_VALUE;

        for(int weight: weights){
            sum = Math.max(sum, weight);
        }
        return sum;
    }
}