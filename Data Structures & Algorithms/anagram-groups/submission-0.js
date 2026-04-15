class Solution {
    /**
     * @param {string[]} strs
     * @return {string[][]}
     */
    groupAnagrams(strs) {
        const map = new Map();

        for (const word of strs) {
            // Create frequency array for 26 lowercase letters
            const count = new Array(26).fill(0);
            
            for (let i = 0; i < word.length; i++) {
                // word.charCodeAt(i) returns the ASCII value (e.g., 'a' = 97)
                // Subtracting 97 maps 'a' to index 0, 'b' to 1, etc.
                count[word.charCodeAt(i) - 97]++;
            }

            // Convert array to a unique string key like "1,0,2,0..."
            // This ensures all anagrams generate the exact same key.
            const key = count.join(',');

            if (!map.has(key)) {
                // If it's a new "fingerprint", start a new group
                map.set(key, [word]);
            } else {
                // If the group exists, just push the word into it
                map.get(key).push(word);
            }
        }

        // Return only the values (the arrays of grouped words)
        return Array.from(map.values());
    }
}