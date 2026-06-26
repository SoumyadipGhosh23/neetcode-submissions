class Solution {
public:
    string convertArrayToString(vector<int> &arr){
  string s;
  for (int i = 0; i < arr.size(); i++) {
      s += to_string(arr[i]);
      if (i != arr.size() - 1)
          s += ",";
  }
  
  return s;
}
vector<vector<string>> groupAnagrams(vector<string>& strs) {
  unordered_map<string, vector<string>> mp;
  for(auto word:strs){
    vector<int> count(26,0);
    for(auto ch : word){
      count[ch - 'a']++;
    }
    string countString = convertArrayToString(count);
    if(mp.find(countString) != mp.end()){
      mp[countString].push_back(word);
    }else{
      mp[countString] = {word};
    }
  }
  vector<vector<string>> result;
  for(auto itr : mp){
    result.push_back(itr.second);
  }
  return result;
}
};
