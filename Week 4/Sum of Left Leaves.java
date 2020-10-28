/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private int recur(TreeNode root)
    {
        if(root == null)
            return 0;
        System.out.println(root.val + " " + leaf_sum);
        if(root.left == null && root.right == null)
        {
            return root.val;
        }
        int x = recur(root.left);
        leaf_sum += x;
        recur(root.right);
        System.out.println(root.val + " " + leaf_sum + " " + x);
        return 0;
    }
    
    private int leaf_sum;
    
    public int sumOfLeftLeaves(TreeNode root) {
        leaf_sum = 0;
        
        recur(root);
        
        return leaf_sum;
    }
}