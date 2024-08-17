class Solution {
      public static int rec(int a[],int l,int r)
    {
        if(l>r)
            return Integer.MIN_VALUE;
            
        if(l==r)
            return a[l];
            
        int mid = l + (r-l)/2;
        
        int left = rec(a, l, mid);
        int right = rec(a, mid+1, r);
        
        return Math.max(left, right);
    }
    
    public static int largest(int n, int[] arr)
    {
        int l =0;
        int r = n-1;
        return (rec(arr,l,r));
    }
}
