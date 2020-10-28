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
    
    
    private void process(TreeNode node, int[] res, int currSum, int sum, HashMap<Integer, Integer> sums) {
        if (node == null) {
            return;
        }
        int newSum = currSum + node.val;
        if (sums.containsKey(newSum - sum)) {
            res[0] += sums.get(newSum - sum);
        }
        if (!sums.containsKey(newSum)) {
            sums.put(newSum, 0);
        }
        sums.put(newSum, sums.get(newSum) + 1);
        process(node.left, res, newSum, sum, sums);
        process(node.right, res, newSum, sum, sums);
        sums.put(newSum, sums.get(newSum) - 1);
    }
    
    private void dfs(TreeNode root, int curr, Set<Integer> st)
    {
        if(root == null)
            return;
        
        Set<Integer> st1 = new HashSet<Integer>(st);
        curr += root.val;
        //System.out.println("node val: " + root.val + ", curr: " + curr + ", s: " + s + ", count: " + count);
        if(curr == s)
            count++;
        if(root.val == s)
            count++;
        if(s!=0 && (root.val!=(-s)) && st.contains(curr+s))
        {
            count++;
            //System.out.println("curr+s: " + (curr+s));
        }
        if(s != 0 && (root.val!=s) && st.contains(curr-s))
        {
            count++;
            //System.out.println("curr-s: " + (curr-s));
        }
        st1.add(curr);
        dfs(root.left, curr, st1);
        dfs(root.right, curr, st1);
        return;
    }
    
    ////private Set<Integer> st;
    private int s;
    private int count;
    
    public int pathSum(TreeNode root, int sum) {
        // s = sum;
        // Set<Integer> st = new HashSet<Integer>();
        // //st.add(0);
        // count = 0;
        // int curr = 0;
        // if(root == null)
        //     return 0;
        // curr += root.val;
        // //System.out.println("node val: " + root.val + ", curr: " + curr + ", s: " + s + ", count: " + count);
        // if(curr == s)
        //     count++;
        // st.add(curr);
        // dfs(root.left, curr, st);
        // dfs(root.right, curr, st);
        // return count;
        
        HashMap<Integer, Integer> sums = new HashMap<Integer, Integer>();
        sums.put(0, 1);
        int[] res = new int[1];
        process(root, res, 0, sum, sums);
        return res[0];
    }
}