class Solution {
    
    
    
    public int mincostTickets(int[] days, int[] costs) {
        if(days.length == 1)
            return Math.min(costs[0], Math.min(costs[1], costs[2]));
        
        int prevMin = 0;
        int len = days.length;
        int[] minimum = new int[days.length];
        Arrays.fill(minimum, Integer.MAX_VALUE);
        
        for(int i = 0; i < len; i++)
        {
            int c1 = prevMin + costs[0];
            
            if(minimum[i] > c1)
                minimum[i] = c1;
            
            int c2 = prevMin + costs[1];
            
            for(int j = i+1; (j < len) && (days[j] < days[i] + 7); j++)
            {
                if(minimum[j] > c2)
                    minimum[j] = c2;
            }
            
            int c3 = prevMin + costs[2];
            for(int j = i+1; (j < len) && (days[j] < days[i] + 30); j++)
            {
                if(minimum[j] > c3)
                    minimum[j] = c3;
            }
            prevMin = Math.min(c1, Math.min(c2, c3));
            
            if(prevMin < minimum[i])
                minimum[i] = prevMin;
            else
                prevMin = minimum[i];
            
        }
        
        
        return prevMin;
    }
}