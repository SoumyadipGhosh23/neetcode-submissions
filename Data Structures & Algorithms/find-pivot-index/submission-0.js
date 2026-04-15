class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    pivotIndex(nums) {
        let sum = 0
        const prefixSumArr = []
        nums.forEach((ele)=> prefixSumArr.push(sum+=ele))
        sum = 0
        const suffixSumArr = []
        for(let i = nums.length -1 ; i>=0; i--){
            suffixSumArr.push(sum+=nums[i])
        }
        suffixSumArr.reverse()

        for(let i = 0; i<nums.length; i++){
            if(prefixSumArr[i] == suffixSumArr[i]) return i
        }
        return -1
    }
}

// 1 8 11 17 22 28
// 28 27 20 17 11 6