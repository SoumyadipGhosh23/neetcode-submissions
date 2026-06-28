class Solution {
public:

    int characterReplacement(string s, int k) {
        int i = 0, j =0;
        unordered_map<char, int> mp;
        int result = 0;
        int maxFreq = 0;
        while(j<s.length()){
            mp[s[j]]++;
            maxFreq = max(maxFreq, mp[s[j]]);
            while(j-i+1 - maxFreq > k){
                mp[s[i]]--;
                i++;
            }
            result = max(result, j-i+1);
            j++;
        }
        return result;
    }
};