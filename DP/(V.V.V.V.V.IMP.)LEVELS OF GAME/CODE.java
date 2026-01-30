class Solution {

    public int maxLevel(int h, int m) {
        // code here
        /***his would have made sens if for 2nd , we are decreasing by 5, 10 already , and for third we were decreasing by 10, 20, but we are increasing one by 5 and decreasing other by 20. How does this playout. I mean what if h was very big at first, and m was smaller. ytou getting my point, i understood the priority but prioristation of 2 over 3 is quite diabolocal.***/

        boolean r1 = true;
        int ans = 0;

        while(h>0 && m>0){
            if(r1){
                h = h+3;
                m = m+2;
                r1 = false;
                ans++;
            }else{
                r1 = true;

                if(h>5 && m>10){
                    h = h-5;
                    m = m-10;
                    ans++;
                }else if(h>20){
                    h = h-20;
                    m = m+5;
                    ans++;
                }else{
                    break;
                }
            }
        }

        return ans;

    }
}
