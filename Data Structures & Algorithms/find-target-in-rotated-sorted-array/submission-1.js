class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number}
     */
    search(nums, target) {
        let left = 0, right = nums.length-1;
        while(left <= right){
            let mid = left + Math.floor((right-left)/2);
            if(nums[mid] == target) return mid;

            //rotation is in right, that means left side is already sorted, so we will check in the sorted part
            if(nums[mid] > nums[right]){
                if(nums[left] <= target && nums[mid] > target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            //rotation is in left, so we will perform binary search in right half that is sorted
            else{
                if(nums[right] >= target && nums[mid]<target){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }

        }
        return -1;
    }
}
