class Solution {
public:
    vector<int> topKFrequent(vector<int> &nums, int k) {
  unordered_map<int, int> mp;
  vector<int> result;
  for (auto itr : nums) {
    mp[itr]++;
  }
  vector<pair<int, int>> v(mp.begin(), mp.end());

  sort(v.begin(), v.end(),
       [](auto &a, auto &b) { return a.second > b.second; });
  for (int i = 0; i < k; i++) {
    result.push_back(v[i].first);
  }

  sort(result.begin(), result.end());

  return result;
}
};
