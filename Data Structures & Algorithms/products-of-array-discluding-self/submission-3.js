class Solution {
    /**
     * @param {number[]} nums
     * @return {number[]}
     */
    productExceptSelf(nums) {
        let prefixMultiplications = [];
        let multiplications= 1;
        let suffixMultiplications = [];
        for(let i = 0; i<nums.length; i++){
            prefixMultiplications.push(multiplications *= nums[i]);
        }
        multiplications = 1;
        for(let i = nums.length -1; i>=0; i--){
            suffixMultiplications.push(multiplications *= nums[i]);
        }
        suffixMultiplications.reverse();
        let result = []
        for(let i = 0; i < nums.length; i++){
            let temp = 1;
            if(i-1 >= 0){
                temp *= prefixMultiplications[i-1]
            }
            if(i+1 < nums.length){
                temp *= suffixMultiplications[i+1]
            }
            result.push(temp);
        }
        return result;
    }
}
