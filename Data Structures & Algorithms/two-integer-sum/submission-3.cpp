class Solution {
public:
   vector<int> twoSum(vector<int> &nums, int target) {
  unordered_map<int, int> mp;
  for(int i = 0; i<nums.size(); i++){
   if (mp.find(target - nums[i]) != mp.end()){
      vector<int> result = {mp[target-nums[i]], i};
      sort(result.begin(), result.end());
      return result;
    }
    mp[nums[i]] = i;
  }
  return {0,0};
}
};
