class Solution {
    private Deque<Integer> stack = new ArrayDeque<>();
    private List<String> operators = new ArrayList<>(Arrays.asList("+", "-", "*", "/", "%"));
    public int evalRPN(String[] tokens) {
        int result = 0;
        for(int i = 0; i<tokens.length; i++){
            if(operators.contains(tokens[i])){
                int last = stack.pop();
                int first = stack.pop();
                if (tokens[i].equals("+")) {
                    result = first + last;
                    stack.push(result);
                } else if (tokens[i].equals("-")) {
                    result = first - last;
                    stack.push(result);
                } else if (tokens[i].equals("*")) {
                    result = first * last;
                    stack.push(result);
                } else if (tokens[i].equals("/")) {
                    result = first / last;
                    stack.push(result);
                } else if (tokens[i].equals("%")) {
                    result = first % last;
                    stack.push(result);
                }
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
