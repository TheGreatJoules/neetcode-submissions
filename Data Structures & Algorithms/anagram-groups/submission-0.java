class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] strSorted = str.toLowerCase().toCharArray();
            Arrays.sort(strSorted);
            map.putIfAbsent(String.valueOf(strSorted), new ArrayList<>());
            map.get(String.valueOf(strSorted)).add(str);
        }
        return map.values().stream().collect(Collectors.toList());
    }
}
