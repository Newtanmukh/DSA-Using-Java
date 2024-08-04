static String findLargest(int N, int S){
        if(S==0 && N>1){
            return "-1";
        }
        if(S>9*N){
            return "-1";
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<N;i++){
            if(S>=9){
                ans.append(9);
                S-=9;
            }
            else{
                ans.append(S);
                S = 0;
            }
        }
        return ans.toString();
    }