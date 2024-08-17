class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = getMaxCapacity(piles);

        int ans = maxSpeed;

        while(minSpeed <= maxSpeed){
            int midSpeed = minSpeed + (maxSpeed - minSpeed)/2;

            if(isEatBeforeTime(midSpeed, h, piles)){
                ans = Math.min(ans, midSpeed);
                maxSpeed = midSpeed - 1; 
            }else{
                minSpeed = midSpeed + 1;
            }
        }

        return ans;

    }

    public boolean isEatBeforeTime(int speed, int hours, int[] piles){
        int num = 0;

        for(int pile: piles){
            num = num + (pile/speed);
            if(pile%speed!=0)
                num++;

            if(num > hours)
                return false;           
        }

        return num<=hours;
    }

    public int getMaxCapacity(int[] piles){
        int sum = 0;
        for(int pile: piles){
            sum = Math.max(sum, pile);
        }

        return sum;
    }
}