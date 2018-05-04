/*
 * [81] Search in Rotated Sorted Array II
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Medium (32.65%)
 * Total Accepted:    120K
 * Total Submissions: 367.6K
 * Testcase Example:  '[2,5,6,0,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return true,
 * otherwise return false.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * 
 * Follow up:
 * 
 * 
 * This is a follow up problem to Search in Rotated Sorted Array, where nums
 * may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 * 
 * 
 */
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
       int pivot = findPivot(nums); 
       int left = 0, right = 0, mid = 0;
       if(nums[0] <= nums[nums.length - 1]){
           left = 0;
           right = nums.length - 1;
       }else{
            if(target <= nums[nums.length - 1]){
                left = pivot + 1;
                right = nums.length -1;
            }else{
                left = 0;
                right = pivot;
            }
       }
       mid = (left + right)/2;
       while(left <= right){
           if(nums[mid] == target){
               return true;
           }
           if(nums[mid] < target){
               left = mid + 1;
           }else{
               right = mid -1;
           }
           mid = left + (right - left)/2;
       }
       return false;
    }
    private int findPivot(int[] nums){
        int left = 0, right = nums.length -1, mid = (left+right)/2; 
        while(left < right){
            if(mid == left){
                if(nums[right] > nums[left]){
                    return right;
                }else{
                    return mid;
                }
            }
            if(nums[mid] >= nums[left]){
                left = mid;
                mid = (left + right)/2;
            }else{
                right = mid - 1;
                mid = (left + right)/2;
            }
        }
        return mid;
    }
}
