
//provlem desc: https://www.geeksforgeeks.org/problems/longest-span-with-same-sum-in-two-binary-arrays5142/1
class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        // code here
        int s1 = 0;
        int s2 = 0;
        int n = a1.length;

        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;

        for(int i=0; i<n; i++){
            s1 += a1[i];
            s2 += a2[i];

            int diff = s1 - s2;

            if(diff==0)
                maxLen = Math.max(diff, i+1);

            if(map.containsKey(diff)){
                maxLen = Math.max(maxLen, i - map.get(diff));
            }else{
                map.put(diff, i);
            }
        }

        return maxLen;
    }
}