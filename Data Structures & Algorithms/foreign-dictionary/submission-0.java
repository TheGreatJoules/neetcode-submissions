class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new LinkedHashMap<>();
        Map<Character, Integer> indegrees = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.computeIfAbsent(c, k -> new HashSet<>());
                indegrees.computeIfAbsent(c, k -> 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            int minLen = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (!graph.get(w1.charAt(j)).contains(w2.charAt(j))) {
                        graph.get(w1.charAt(j)).add(w2.charAt(j));
                        indegrees.put(w2.charAt(j), indegrees.get(w2.charAt(j)) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (char c : indegrees.keySet()) {
            if (indegrees.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            result.append(ch);
            for (char neighbor : graph.get(ch)) {
                indegrees.put(neighbor, indegrees.get(neighbor) - 1);
                if (indegrees.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if (result.length() != indegrees.size()) {
            return "";
        }
        return result.toString();
    }
}
