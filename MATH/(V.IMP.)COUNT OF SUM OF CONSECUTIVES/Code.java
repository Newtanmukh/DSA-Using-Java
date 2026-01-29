class Solution {
//the thing is that we will use 2*n>k*(k-1) and NOT 2*n>=k*(k-1).
//This is because, if it equals zero then the sequence will start from 0, which is not corect.
    int getCount(int n) {
        // code here
        int ans = 0;

        for(int k=2; 2*n>k*(k-1); k++){
            int num = (n - ((k*(k-1)))/2);

            if(num%k==0)
                ans++;
        }

        return ans;
    }
};