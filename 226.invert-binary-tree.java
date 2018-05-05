/*
 * [226] Invert Binary Tree
 *
 * https://leetcode.com/problems/invert-binary-tree/description/
 *
 * algorithms
 * Easy (53.52%)
 * Total Accepted:    232K
 * Total Submissions: 433.6K
 * Testcase Example:  '[4,2,7,1,3,6,9]'
 *
 * Invert a binary tree.
 * 
 * 
 * ⁠    4
 * ⁠  /   \
 * ⁠ 2     7
 * ⁠/ \   / \
 * 1   3 6   9
 * 
 * to
 * 
 * 
 * ⁠    4
 * ⁠  /   \
 * ⁠ 7     2
 * ⁠/ \   / \
 * 9   6 3   1
 * 
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 * 
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you
 * can’t invert a binary tree on a whiteboard so f*** off.
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Stack;
class Solution {
   static  class Record {
            public TreeNode node;
            public int count = 2;
            public Record(TreeNode node) {
                this.node = node;
         }
}
    public TreeNode invertTree(TreeNode root) {
        Stack<Record> stack = new Stack<>();
        if (root != null)
            stack.push(new Record(root));
        while (!stack.isEmpty()) {
            Record record = stack.pop();
            if (record.count == 2) {
                record.count -= 1;
                if (record.node.left != null) {
                    stack.push(record);
                    stack.push(new Record(record.node.left));
                    continue;
                }
            }
            if (record.count == 1) {
                record.count -= 1;
                if (record.node.right != null) {
                    stack.push(record);
                    stack.push(new Record(record.node.right));
                    continue;
                }
            }
            if (record.count == 0) {
                TreeNode tmp = record.node.left;
                record.node.left = record.node.right;
                record.node.right = tmp;
            }
        }
        return root;
    }
}
