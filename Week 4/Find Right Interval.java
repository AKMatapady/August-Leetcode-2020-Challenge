class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int max = Integer.MIN_VALUE;
        //start point -> index
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int len = intervals.length;
        for(int i = 0; i < len; i++)
        {
            mp.put(intervals[i][0], i);
            if(max < intervals[i][0])
                max = intervals[i][0];
        }
        
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        for(int i = 0; i < len; i++)
        {
            int sp = intervals[i][0];
            if(sp < max && intervals[i][1] <= max)
            {
                for(int j = intervals[i][1]; j <= max; j++)
                {
                    Integer t = mp.get(j);
                    if(t != null && ((int)t != i))
                    {
                        ans[i] = t;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}