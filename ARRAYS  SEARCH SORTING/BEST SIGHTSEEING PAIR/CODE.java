class Solution {
    public int maxScoreSightseeingPair(int[] values) {

        int n = values.length;
        int maxAns = Integer.MIN_VALUE;

        int leftMaxi = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            maxAns = Math.max(maxAns, values[i]-i + leftMaxi);
            leftMaxi = Math.max(leftMaxi, values[i] + i);
        }

        return maxAns;
    }
}