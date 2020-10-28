class Solution {
    
    private class Interval
    {
        int x;
        int y;
        public Interval(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if(intervals == null || intervals.length < 2)
            return 0;
        int len = intervals.length;
        
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>((a,b)->{
            if(a.y < b.y)
                return -1;
            if(a.y > b.y)
                return 1;
            return 0;
            // if(a.x == b.x)
            // {
            //     if(a.y < b.y)
            //         return -1;
            //     if(a.y > b.y)
            //         return 1;
            //     return 0;
            // }
            // if(a.x < b.x)
            //     return -1;
            // return 1;
        });
        
        for(int[] arr: intervals)
        {
            Interval temp = new Interval(arr[0], arr[1]);
            pq.add(temp);
        }
        int covered = Integer.MIN_VALUE;
        int count = 0;
        while(!pq.isEmpty())
        {
            Interval temp = pq.poll();
            if(temp.x < covered)
            {
                count++;
                continue;
            }
            covered = temp.y;
        }
        return count;
    }
}