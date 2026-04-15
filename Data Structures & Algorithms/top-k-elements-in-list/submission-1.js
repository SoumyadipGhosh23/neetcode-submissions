class Solution {
  /**
   * @param {number[]} nums
   * @param {number} k
   * @return {number[]}
   */
    topKFrequent(nums, k) {
        const map = new Map()
        const res = []

        nums.forEach(ele => map.set(ele, (map.get(ele) || 0) + 1))

        const sortedMap = [...map.entries()].sort((a, b) => b[1] - a[1])

        for (let i = 0; i < k; i++) {
            res.push(sortedMap[i][0])
        }

        return res
    }
}
