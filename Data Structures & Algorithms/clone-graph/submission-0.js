class Solution {
    cloneGraph(node) {
        if (node === null) {
            return null;
        }

        const oldToNew = new Map();

        const dfs = (node) => {
            // Already cloned
            if (oldToNew.has(node)) {
                return oldToNew.get(node);
            }

            // Create clone
            const copy = new Node(node.val);

            // IMPORTANT: store it immediately
            oldToNew.set(node, copy);

            // Clone all neighbors
            for (const neighbor of node.neighbors) {
                copy.neighbors.push(dfs(neighbor));
            }

            return copy;
        };

        return dfs(node);
    }
}