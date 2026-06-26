class Solution {
public:
bool isAlphaNum(char c) {
    return (c >= '0' && c <= '9') ||
           (c >= 'a' && c <= 'z') ||
           (c >= 'A' && c <= 'Z');
}
bool isPalindrome(string s) {
    int i = 0, j = s.size() - 1;

    while (i < j) {

        while (i < j && !isAlphaNum(s[i])) i++;
        while (i < j && !isAlphaNum(s[j])) j--;

        char left = s[i];
        char right = s[j];

        // manual lowercase conversion
        if (left >= 'A' && left <= 'Z')
            left += 32;

        if (right >= 'A' && right <= 'Z')
            right += 32;

        if (left != right)
            return false;

        i++;
        j--;
    }

    return true;
}
};
