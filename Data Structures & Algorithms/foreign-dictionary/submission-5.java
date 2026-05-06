class Solution {
    Map<Character, Set<Character>> graph;
    Map<Character, Boolean> visited;
    LinkedList<Character> result;

    public String foreignDictionary(String[] words) {
        graph = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.computeIfAbsent(c, k -> new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            int minLength = Math.min(w1.length(), w2.length());
            if (w1.length() > minLength
            && w1.substring(0, minLength).equals(w2.substring(0, minLength))) {
                return "";
            }
            for (int j = 0; j < minLength; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    graph.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        visited = new HashMap<>();
        result = new LinkedList<>();
        for (char c : graph.keySet()) {
            System.out.println("key @ " + c);
            if (dfs(c)) {
                return "";
            }
        }
        // Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }
        return sb.toString();
    }

    private boolean dfs(char ch) {
        if (visited.containsKey(ch)) {
            return visited.get(ch);
        }
        visited.put(ch, true);
        for (char next : graph.get(ch)) {
            if (dfs(next)) {
                return true;
            }
        }
        visited.put(ch, false);
        result.addFirst(ch);
        return visited.get(ch);
    }
}
