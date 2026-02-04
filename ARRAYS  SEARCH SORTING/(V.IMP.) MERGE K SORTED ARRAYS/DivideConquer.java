class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {

        ArrayList<Integer> ans = new ArrayList<>();

        int[] arr = mergeArrays(0, mat.length-1, mat);

        for(int i: arr)
            ans.add(i);

        return ans;
    }


    public int[] mergeArrays(int low, int high, int[][] max){
        if(low > high)
            return new int[0];

        if(low==high)
            return max[low];

        int mid = low + (high - low)/2;

        int[] left = mergeArrays(low, mid, max);
        int[] right = mergeArrays(mid+1, high, max);

        return returnMergedArrays(left, right);
    }


    public int[] returnMergedArrays(int[] lhs, int[] rhs){
        int m = lhs.length;
        int n = rhs.length;

        int[] ans = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i<m && j<n){
            if(lhs[i] < rhs[j]){
                ans[k] = lhs[i];
                i++;
            }else{
                ans[k] = rhs[j];
                j++;
            }

            k++;
        }

        while(i<m){
            ans[k] = lhs[i];
            i++;
            k++;
        }


        while(j<n){
            ans[k] = rhs[j];
            j++;
            k++;
        }

        return ans;
    }
}