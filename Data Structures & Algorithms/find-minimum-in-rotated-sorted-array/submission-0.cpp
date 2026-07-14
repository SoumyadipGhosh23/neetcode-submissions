class Solution {
public:
    int findMin(vector<int> &nums) {
    int left = 0, right = nums.size() - 1;
    
    while (left < right) {
        int mid = left + (right - left) / 2;
        
        // If mid is greater than the rightmost element, 
        // the inflection point (min) is in the right half.
        if (nums[mid] > nums[right]) {
            left = mid + 1;
        } 
        // Otherwise, the min is either mid or to the left of mid.
        else {
            right = mid; 
        }
    }
    
    // When left == right, they both point to the minimum element.
    return nums[left];
}
};
