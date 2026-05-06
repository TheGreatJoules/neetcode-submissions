class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                graph.computeIfAbsent(word.charAt(i), k -> new HashSet<>());
                indegree.putIfAbsent(word.charAt(i), 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLength = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() 
            && w1.substring(0, minLength).equals(w2.substring(0, minLength))) {
                return "";
            }
            for (int j = 0; j < minLength; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (!graph.get(w1.charAt(j)).contains(w2.charAt(j))) {
                        graph.get(w1.charAt(j)).add(w2.charAt(j));
                        indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.append(current);
            for (char neighbor : graph.get(current)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if (result.length() != indegree.size()) {
            return "";
        }
        return result.toString();
    }
}
