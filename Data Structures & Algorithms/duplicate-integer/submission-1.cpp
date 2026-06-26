class Solution {
public:
    bool hasDuplicate(vector<int>& arr) {
        unordered_map<int, int> mp;

    for (int i = 0; i < arr.size(); i++) {
        if (mp[arr[i]] != 0) {
            return true;
        }

        mp[arr[i]]++;
    }

    return false;
    }
};