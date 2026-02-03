class Solution {
    static String maxSum(String w, char x[], int b[], int n) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(x[i], b[i]);
        }

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        int currStart = 0;
        int bestStart = 0;
        int bestEnd = 0;

        for (int i = 0; i < w.length(); i++) {

            int val = map.containsKey(w.charAt(i))
                    ? map.get(w.charAt(i))
                    : (int)w.charAt(i);

            if (currSum + val >= val) {
                currSum += val;
            } else {
                currSum = val;
                currStart = i;
            }

            if (currSum > maxSum) {
                maxSum = currSum;
                bestStart = currStart;
                bestEnd = i;
            }
        }

        return w.substring(bestStart, bestEnd + 1);
    }
}