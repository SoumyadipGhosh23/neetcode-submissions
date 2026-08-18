class Solution {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        // 1. Build Trie
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.word = word;
        }

        int rows = board.length;
        int cols = board[0].length;
        List<String> result = new ArrayList<>();

        // 2. Launch DFS from every cell that matches a root prefix
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (root.children.containsKey(board[r][c])) {
                    dfs(board, r, c, root, result);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode parentNode, List<String> result) {
        char ch = board[r][c];
        TrieNode currNode = parentNode.children.get(ch);

        if (currNode == null) return;

        // Word matched
        if (currNode.word != null) {
            result.add(currNode.word);
            currNode.word = null; // Avoid duplicate collection
        }

        // Mark visited in-place
        board[r][c] = '#';

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                if (board[nr][nc] != '#' && currNode.children.containsKey(board[nr][nc])) {
                    dfs(board, nr, nc, currNode, result);
                }
            }
        }

        // Backtrack board state
        board[r][c] = ch;

        // 3. Trie Pruning: Remove leaf node to prevent re-traversals
        if (currNode.children.isEmpty()) {
            parentNode.children.remove(ch);
        }
    }
}