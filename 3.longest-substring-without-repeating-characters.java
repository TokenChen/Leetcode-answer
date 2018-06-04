/*
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (24.76%)
 * Total Accepted:    494.2K
 * Total Submissions: 2M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        int[] indexOfCharacter = new int[128];
        for(int i = 0; i < 128; i++){
            indexOfCharacter[i] = -1;
        }
        int tempLength = 0, tempStart = 0;
        for(int k = 0; k < s.length(); k++){
            int tempIndex = s.charAt(k);
            int tempValue = indexOfCharacter[tempIndex] ;

            if(k == (s.length() -1)){
                if(tempValue == -1 || tempValue < tempStart){
                    if(tempLength < (s.length() -  tempStart)){
                         tempLength = s.length() - tempStart;
                    }
                }
            }

            if(tempValue != -1 && tempValue >= tempStart){
                if(tempLength < (k -  tempStart)){
                    tempLength = k - tempStart;
                }
                tempStart = tempValue + 1;
            }
            indexOfCharacter[tempIndex] = k;
        }
        return tempLength;
        
    }
}
