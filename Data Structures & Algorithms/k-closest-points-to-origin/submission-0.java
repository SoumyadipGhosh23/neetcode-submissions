class Solution {
  private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        int[][] ans = new int[k][2];

        // Store {index, distance}
        for (int i = 0; i < points.length; i++) {
            int dist = distance(points[i]);
            pq.offer(new int[] { i, dist });
        }

        // Take k closest points
        for (int i = 0; i < k; i++) {
            int[] pair = pq.poll();

            int index = pair[0];

            ans[i] = points[index];
        }

        return ans;
    }
}
