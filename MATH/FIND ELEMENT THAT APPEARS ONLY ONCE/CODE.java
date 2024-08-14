class Sol {
    public  int search(int N, int arr[]) {
            int ans =0;
        
        for(int i=0;i<N;i++)
        ans^=arr[i];
        
        return ans;
    }
}