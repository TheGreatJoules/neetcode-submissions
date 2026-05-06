class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                stack.push(i);
            } else if (sb.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    sb.setCharAt(i, '\0');
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '\0');
        }
        return sb.chars()
                .filter(ch -> ch != '\0')
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());
    }
}