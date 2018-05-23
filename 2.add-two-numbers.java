/*
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (28.79%)
 * Total Accepted:    502.6K
 * Total Submissions: 1.7M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 * Example
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        ListNode previous = null;
        int needAddMore = 0; 
        while(true){
            if(l1 == null && l2 == null){
                if(needAddMore == 1){
                    current.val = 1;
                }else{
                    previous.next = null;
                }
                break;
            }else if(l1 == null && l2 != null){
                current.val = (l2.val + needAddMore) % 10;
                needAddMore = (l2.val + needAddMore) / 10;
                if(needAddMore == 0){
                    current.next = l2.next;
                    break;
                }else{
                    l2 = l2.next;
                    current.next = new ListNode(0);
                    previous = current;
                    current = current.next;
                    continue;
                }
            }else if(l1 != null && l2 == null){
                current.val = (l1.val + needAddMore) % 10;
                needAddMore = (l1.val + needAddMore) / 10;
                if(needAddMore == 0){
                    current.next = l1.next;
                    break;
                }else{
                    l1 = l1.next;
                    current.next = new ListNode(0);
                    previous = current;
                    current = current.next;
                    continue;
                }
            }
            current.val = (l1.val + l2.val + needAddMore) % 10;
            needAddMore = (l1.val + l2.val + needAddMore) / 10;
            current.next = new ListNode(0);
            previous = current;
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        } 
        return result;
        
    }
}
