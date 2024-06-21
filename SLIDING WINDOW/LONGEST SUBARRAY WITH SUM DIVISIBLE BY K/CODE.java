 int longSubarrWthSumDivByK(int arr[], int n, int k)
    {
        if (k == 1)
            return n;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            int hash = ((sum % k) + k) % k;

            if (hash == 0)
                maxLen = Math.max(maxLen, i + 1);

            if (hashMap.get(hash) != null) {
                maxLen = Math.max(maxLen, i - hashMap.get(hash));
            } else {
                hashMap.put(hash, i);
            }
        }
        return maxLen;
       
    }