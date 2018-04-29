/*
 * [148] Sort List
 *
 * https://leetcode.com/problems/sort-list/description/
 *
 * algorithms
 * Medium (29.90%)
 * Total Accepted:    131.7K
 * Total Submissions: 440.4K
 * Testcase Example:  '[4,2,1,3]'
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example 1:
 * 
 * 
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        int num = 0;
        ListNode temp = head;
        while(temp != null){
            num++;
            temp = temp.next;
        }

        return mergeSort(head, num);
    }

    private ListNode mergeSort(ListNode head, int length){
        if(length == 1){
            return head;
        }
        if(length == 0){
            return head;
        }
        ListNode left = head;
        ListNode right = head;
        for(int i = 0; i < length/2 - 1 ; i++){
            head = head.next;
        }
        right = head.next;
        head.next = null;

        return mergeTwoList(mergeSort(left, length/2), mergeSort(right, (length - (length/2) ) ) );
    }

    private ListNode mergeTwoList(ListNode left, ListNode right){
        if(left == null || right== null){
            System.out.println("input array is invalid");
            return null;
        }
        ListNode result = new ListNode(0) , current = result;
        while(left != null || right != null){

            if(left == null){
                current.next = right;
                break;
            }
            if(right == null){
                current.next = left;
                break;
            }

            if(left.val > right.val){
                current.next = right;
                right = right.next;
            }else{
                current.next = left;
                left = left.next;
            }
            current = current.next;
        }
        return result.next;

    }
}
