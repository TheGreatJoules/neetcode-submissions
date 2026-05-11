class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int result = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
