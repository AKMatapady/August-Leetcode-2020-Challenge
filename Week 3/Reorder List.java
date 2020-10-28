/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        HashMap<Integer, ListNode> mp = new HashMap<Integer, ListNode>();
        int l = 0;
        ListNode curr = head;
        while(curr != null)
        {
            mp.put(l++, curr);
            curr = curr.next;
        }
        int i = 0, j = l-1;
        while(i < j)
        {
            ListNode left = mp.get(i);
            ListNode right = mp.get(j);
            left.next = right;
            ListNode next = null;
            if(i+1 < j)
            {
                next = mp.get(i+1);                
                //System.out.println(left.val + " -> " + right.val + " -> " + next.val);
                if((j-i) == 2)
                {
                    next.next = null;
                }
            }
            // else
            // {
            //     System.out.println(left.val + " -> " + right.val);
            // }
            right.next = next;
            i++;
            j--;
        }
        
        return;
    }
}