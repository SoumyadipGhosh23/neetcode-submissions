class Solution {
    private Deque<Integer> stack = new ArrayDeque<>();
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Arrays.fill(res,0);
        for(int i = 0; i<temperatures.length; i++){
            if(stack.isEmpty()) {
                stack.push(i);
            } else {
                while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    int prev = stack.pop();
                    res[prev] = i - prev;
                }
                stack.push(i);
            }
        }
        return res;
    }
}