class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        int twentys = 0;//NOTE : always try to give away the larger denomination first. then smaller denomination.

        for(int bill: bills){
            if(bill==5){
                fives++;
            }else if(bill==10){
                if(fives==0){
                    return false;
                }
                fives--;
                tens++;
            }else{
                if((fives < 3) && (fives==0 || tens==0)){
                    return false;
                }

                if(tens>0 && fives>0){
                    tens--;
                    fives--;
                }else{
                    fives = fives - 3;
                }

                twentys++;
            }
        }

        return true;
    }
}