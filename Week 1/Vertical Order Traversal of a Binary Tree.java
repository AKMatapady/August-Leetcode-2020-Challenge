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
    
    private class Pos
    {
        Integer x;
        Integer y;
        Integer val;
        
        public Pos(int a, int b, int v)
        {
            x = a;
            y = b;
            val = v;
        }
    }
    
    private PriorityQueue<Pos> pq;
    
    private void traverse(TreeNode root, int x, int y)
    {
        if(root == null)
            return;
        Pos node = new Pos(x, y, root.val);
        pq.add(node);
        traverse(root.left, x-1, y-1);
        traverse(root.right, x+1, y-1);
        return;
    }
    
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(root == null)
            return ans;
        
        pq = new PriorityQueue<Pos>(new Comparator<Pos>(){
            @Override
            public int compare(Pos a, Pos b)
            {
                if(a.x == b.x)
                {
                    if(a.y == b.y)
                        return (a.val).compareTo(b.val);
                    return (b.y).compareTo(a.y);
                }
                return (a.x).compareTo(b.x);
            }
        });
        
        traverse(root, 0, 0);
        
        Pos firstNode = pq.poll();
        int x = firstNode.x;
        List<Integer> sub = new ArrayList<Integer>();
        sub.add(firstNode.val);
        
        while(!pq.isEmpty())
        {
            Pos node = pq.poll();
            if(node.x > x)
            {
                ans.add(sub);
                sub = new ArrayList<Integer>();
                sub.add(node.val);
                x = node.x;
                continue;
            }
            sub.add(node.val);
        }
        //might be a redundant check
        //if(sub.size() > 0)
            ans.add(sub);
        return ans;
    }
}