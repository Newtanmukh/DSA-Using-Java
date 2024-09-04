class Solution {
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int countPairs = 0;

        for(int num: nums){
            countPairs += hashMap.getOrDefault(num-k, 0) + hashMap.getOrDefault(k+num, 0);
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        return countPairs;
    }
}