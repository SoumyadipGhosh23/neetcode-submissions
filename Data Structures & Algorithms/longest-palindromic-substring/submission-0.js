class Solution {
    /**
     * @param {string} s
     * @return {string}
     */
    longestPalindrome(s) {
          let resStart = 0;
    let resLen = 1;

    function expand(left, right) {
        while (
            left >= 0 &&
            right < s.length &&
            s[left] === s[right]
        ) {
            const len = right - left + 1;

            if (len > resLen) {
                resStart = left;
                resLen = len;
            }

            left--;
            right++;
        }
    }

    for (let i = 0; i < s.length; i++) {
        // Odd length
        expand(i, i);

        // Even length
        expand(i, i + 1);
    }

    return s.substring(resStart, resStart + resLen);
    }
}
