class WordDictionary {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return match(word, 0, root);
    }

    private boolean match(String word, int index, TrieNode curr) {
        if (curr == null) return false;
        if (index == word.length()) return curr.isEnd;

        char ch = word.charAt(index);

        if (ch == '.') {
            // Wildcard: try all non-null children
            for (TrieNode child : curr.children) {
                if (child != null && match(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            // Regular char
            int idx = ch - 'a';
            return match(word, index + 1, curr.children[idx]);
        }
    }
}