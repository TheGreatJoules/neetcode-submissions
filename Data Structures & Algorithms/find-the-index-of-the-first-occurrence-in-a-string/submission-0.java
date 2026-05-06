public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        String s = needle + "$" + haystack;
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = z[i - l];
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        for (int i = needle.length() + 1; i < n; i++) {
            if (z[i] == needle.length()) {
                return i - needle.length() - 1;
            }
        }

        return -1;
    }
}