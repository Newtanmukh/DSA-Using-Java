// User function Template for C++
//problem desc: https://www.geeksforgeeks.org/problems/a-game-of-lcm2531/1
class Solution {
    public:
    long maxGcd(int N) {

        // code here

        long ans = 0;

        int i,j,k,l;

        for(i=1;i<=N;i++)

        {

            for(j=1;j<=N;j++)

            {

                for(k=1;k<=N;k++)

                {

                    for(l=1;l<=N;l++)

                    {

                        long x = (i*j)/gcd(i,j);

                        long y = (k*l)/gcd(k,l);

                        long z = (x*y)/gcd(x,y);

                        ans = max(ans , z);

                    }

                }

            }

        }

        return ans;

    }

    long gcd(long a , long b){

        if(b == 0) return a;

        return gcd(b,a%b);

    }
};