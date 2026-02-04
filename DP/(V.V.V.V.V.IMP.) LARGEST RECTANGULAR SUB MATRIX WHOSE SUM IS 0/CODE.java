
class Solution {
    public static int zeroSumSubmat(int[][] mat) {
        // code here

        int n = mat.length;
        int m = mat[0].length;
        int ans = 0;

        for(int top=0; top<n; top++){
            int[] temp = new int[m];

            for(int bottom = top; bottom<n; bottom++){

                for(int col=0; col<m; col++){
                    temp[col] += mat[bottom][col];
                }

                int len = getLenthOfMaxSubarray(temp, 0);
                ans = Math.max(ans, (bottom-top+1)*(len));
            }
        }

        return ans;
    }

    private static int getLenthOfMaxSubarray(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();

        int n = arr.length;
        int sum = 0;
        int len = 0;

        for(int i=0; i<n; i++){
            sum = sum + arr[i];
            if(sum == target){
                len = Math.max(len, i+1);
            }

            if(map.containsKey(sum-target)){
                len = Math.max(len, i-map.get(sum-target));
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }

        return len;
    }
}
