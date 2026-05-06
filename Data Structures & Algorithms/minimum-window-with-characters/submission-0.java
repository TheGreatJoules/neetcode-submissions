class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) {
            return "";
        }
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        int have = 0;
        int need = countT.size();
        int[] result = {-1, -1};
        int resultLength = Integer.MAX_VALUE;
        for (int right = 0, left = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }
            while (have == need) {
                if ((right - left + 1) < resultLength) {
                    resultLength = right - left + 1;
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
        
        return resultLength == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }
}
