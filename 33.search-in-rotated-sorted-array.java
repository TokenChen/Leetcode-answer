/*
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (31.91%)
 * Total Accepted:    255.7K
 * Total Submissions: 801.2K
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * 
 */
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int pivot = findPivot(nums);

        int left = 0, right = nums.length -1, mid = (left + right)/2;
        while(left <= right){
            if(target > nums[convertIndex(nums.length, pivot, mid)] ){
                left = mid + 1;
                mid = (left + right)/2;
            }else if(target < nums[convertIndex(nums.length, pivot, mid)] ){
                right = mid -1;
                mid = (left + right) / 2;
            }else{
                return convertIndex(nums.length, pivot, mid);
            }
        }
        return -1;
        
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
            if(nums[mid] > nums[left]){
                left = mid;
                mid = (left + right)/2;
            }else{
                right = mid;
                mid = (left + right)/2;
            }
        }
        return mid;
    }
    private int convertIndex(int length, int pivot, int newIndex){
        int leftLength = pivot + 1;
        int rightLength = length - leftLength;
        if(newIndex < rightLength) {
            return leftLength + newIndex;
        }else{
            return newIndex - rightLength;
        }       
    }
}
