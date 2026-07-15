
class Solution {
private:
  int maxElement(vector<int> &piles) {
    int highest = piles[0];
    for (int i = 1; i < piles.size(); i++) {
      highest = max(highest, piles[i]);
    }
    return highest;
  }

  long long timetoEatWholePiles(vector<int> &piles, int speed) {
    long long time = 0; 
    for (int i = 0; i < piles.size(); i++) {
      time += piles[i] / speed + (piles[i] % speed != 0);
    }
    return time;
  }

public:
  int minEatingSpeed(vector<int> &piles, int h) {
    int left = 1, right = maxElement(piles);
    while (left < right) {
      int mid = left + (right - left) / 2;
      
      if (timetoEatWholePiles(piles, mid) <= h) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
};
