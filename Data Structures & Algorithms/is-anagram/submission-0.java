class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sarray = new int[26];

        for (Character c : s.toCharArray()) {
            sarray[c - 'a'] += 1;    
        }

        for (Character c : t.toCharArray()) {
            sarray[c - 'a'] -= 1;    
        }

        for (int item: sarray) {
            if (item != 0) {
                return false;
            }
        }
        return true;

    }
}
