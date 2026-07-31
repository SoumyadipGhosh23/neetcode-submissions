class Solution {
    private Deque<Character> stack = new ArrayDeque<>();
    private List<String> result = new ArrayList<>();

    private void backtrack(int open, int close, int n) {
        // Base case: we used n open and n close brackets
        if (open == n && close == n) {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            result.add(sb.toString());
            return;
        }

        // Option 1: Add '(' if we haven't hit the limit n
        if (open < n) {
            stack.addLast('(');
            backtrack(open + 1, close, n);
            stack.removeLast(); // backtrack
        }

        // Option 2: Add ')' if it won't exceed open brackets
        if (close < open) {
            stack.addLast(')');
            backtrack(open, close + 1, n);
            stack.removeLast(); // backtrack
        }
    }

    public List<String> generateParenthesis(int n) {
        result.clear();
        stack.clear();
        backtrack(0, 0, n);
        return result;
    }
}