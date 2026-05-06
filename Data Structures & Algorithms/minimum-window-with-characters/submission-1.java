class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty() || t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        int have = 0;
        int need = countT.size();
        int size = Integer.MAX_VALUE;
        int[] result = new int[2];
        for (int right = 0, left = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
            if (countT.containsKey(rightChar) && countT.get(rightChar).equals(window.get(rightChar))) {
                have++;
            }
            while (have == need) {
                if ((right - left + 1) < size) {
                    size = right - left + 1;
                    result[0] = left;
                    result[1] = right;
                }
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }
}
