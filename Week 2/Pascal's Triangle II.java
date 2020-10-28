class Solution {
    
    // private int get(int index)
    // {
    //     if(dp != null)
    //     {
    //         int len = dp.length;
    //         if(inde)
    //     }
    //     return -1;
    // }
    
    private int[] dp1;
    private int[] dp2;
    
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<Integer>();
        int k = rowIndex;
        if(k==0)
        {
            ans.add(1);
            return ans;
        }
            
        if(k==1)
        {
            ans.add(1);
            ans.add(1);
            return ans;
        }
        
        dp1 = new int[k+1];
        dp2 = new int[k+1];
        
        dp1[0] = 1;
        dp2[0] = 1;
        dp2[1] = 1;
        
        
        for(int i = 2; i <= k; i++)
        {
            if(i %2==0)
            {
                //update dp1 using dp2
                dp1[0] = 1;
                for(int j = 1; j < i; j++)
                {
                    dp1[j] = dp2[j-1]+dp2[j];
                }
                dp1[i] = 1;
            }
            else
            {
                //update dp2 using dp1
                dp2[0] = 1;
                for(int j = 1; j < i; j++)
                {
                    dp2[j] = dp1[j-1]+dp1[j];
                }
                dp2[i] = 1;
            }
        }
        
        for(int j = 0; j <= k; j++)
        {
            if(k % 2 == 0)
            {
                ans.add(dp1[j]);
            }
            else
            {
                ans.add(dp2[j]);
            }
        }
        
        return ans;
        
    }
}