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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        Stack<TreeNode> nodes = new Stack<TreeNode>();
        TreeNode current = root;
        nodes.push(current);
        boolean isPopedNode = false;
        while(!nodes.isEmpty()){
            if(current.left != null && !isPopedNode){
                nodes.push(current.left);
                isPopedNode = false;
                current = current.left;
            }else if(current.right != null || isPopedNode){
                TreeNode temp = current.left;
                current.left = current.right;
                current.right = temp;
                nodes.pop();
                if(current.left != null){
                    nodes.push(current.left);
                    current = current.left;
                    isPopedNode = false;
                }else{
                    if(!nodes.isEmpty()){
                        current = nodes.peek();
                    }
                    isPopedNode = true;
                }
            }else{
                nodes.pop();
                if(!nodes.isEmpty()){
                    current = nodes.peek();
                }
                isPopedNode = true;
            }
        }

        return root;
    }
}
