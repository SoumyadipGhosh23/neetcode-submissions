class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        // Map closing brackets to their matching opening brackets
        unordered_map<char, char> mp = {
            {')', '('}, 
            {'}', '{'}, 
            {']', '['}
        };

        for (char c : s) {
            // If it's a closing bracket
            if (mp.count(c)) {
                // If stack is empty or top doesn't match, it's invalid
                if (st.empty() || st.top() != mp[c]) {
                    return false;
                }
                st.pop(); // Matched successfully
            } else {
                // It's an opening bracket, push it
                st.push(c);
            }
        }
        
        // If stack is empty, all brackets were matched correctly
        return st.empty();
    }
};