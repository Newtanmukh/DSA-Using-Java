

// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/submissions/1937393745/?envType=daily-question&envId=2026-03-03
class CODE {
    public char findKthBit(int n, int k) {
        StringBuilder s = new StringBuilder("0");

        for (int i = 2; i <= n; i++) {
            StringBuilder inverted = new StringBuilder();

            for (int j = 0; j < s.length(); j++) {
                inverted.append(s.charAt(j) == '0' ? '1' : '0');
            }

            inverted.reverse();
            s.append("1").append(inverted);
        }

        return s.charAt(k - 1);
    }
}