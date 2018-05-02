/*
 * [23] Merge k Sorted Lists
 *
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (28.29%)
 * Total Accepted:    221.7K
 * Total Submissions: 783.5K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }else if(lists.length == 1){
            return lists[0];
        }else{
            ListNode result = new ListNode(0);
            result.next = null;
            ListNode current = result, temp = findMinimumNode(lists);
            while(temp != null){
                current.next = temp;
                current = current.next;
                temp = findMinimumNode(lists);
            }
            return result.next;
        }
    }

    private ListNode findMinimumNode(ListNode[] lists){
        int minimumIndex = -1, minimumValue = -1;
        for(int i = 0; i < lists.length; i++){
            if(lists[i] == null) continue;

            if(minimumIndex == -1){
                minimumIndex = i;
                minimumValue = lists[i].val;

            }else if(lists[i].val < minimumValue){
                minimumIndex = i;
                minimumValue = lists[i].val;
            }
        }
        if(minimumIndex == -1){
            return null;
        }else{
            ListNode result = lists[minimumIndex];
            lists[minimumIndex] = lists[minimumIndex].next;
            return result;
        }
    }

    private ListNode mergeTwoLists(ListNode left, ListNode right){
        ListNode result = new ListNode(0);
        result.next = null;
        ListNode current = result;

        while(true){
            if(left == null){
                current.next = right;
                break;
            }else if(right == null){
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
