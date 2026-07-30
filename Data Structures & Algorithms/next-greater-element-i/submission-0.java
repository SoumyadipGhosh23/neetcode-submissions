class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> nextGreater = new HashMap<>();
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            if (stack.isEmpty()) {
                stack.push(nums2[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                    nextGreater.put(stack.pop(), nums2[i]);
                }
                stack.push(nums2[i]);
            }
        }
        while (!stack.isEmpty()) {
            nextGreater.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextGreater.get(nums1[i]);
        }
        return ans;

    }

}