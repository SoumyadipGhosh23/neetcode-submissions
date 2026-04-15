class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number[]}
     */
    twoSum(nums, target) {
        let indexedNums = nums.map((val, idx) => [val, idx]);
        indexedNums.sort((a, b) => a[0] - b[0]);
        let size = indexedNums.length;
        let i = 0, j = size-1;
        while(i < j){
            let sum = indexedNums[i][0] + indexedNums[j][0]
            if(sum == target) return [indexedNums[i][1], indexedNums[j][1]].sort((a, b) => a - b)
            if(sum > target) j--
            else i++
        }
        return []
    }
}