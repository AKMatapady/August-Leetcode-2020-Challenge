class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length < 1)
            return 0;
        
        int r = grid.length;
        int c = grid[0].length;
        
        Deque<Integer> q = new LinkedList<Integer>();
        
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(grid[i][j] == 2)
                    q.add((i*c)+j);
            }
        }
        
        int minutes = 0;
        
        while(!q.isEmpty())
        {
            int len = q.size();
            for(int i = 0; i < len; i++)
            {
                int x = q.poll();
                int r1 = x /c;
                int c1 = x % c;
                
                if(r1 > 0 && grid[r1-1][c1] == 1)
                {
                    grid[r1-1][c1] = 2;
                    q.add(((r1-1)*c)+c1);
                }
                if((r1+1) < r && grid[r1+1][c1] == 1)
                {
                    grid[r1+1][c1] = 2;
                    q.add(((r1+1)*c)+c1);
                }
                
                if(c1 > 0 && grid[r1][c1-1] == 1)
                {
                    grid[r1][c1-1] = 2;
                    q.add((r1*c)+c1-1);
                }
                if((c1+1) < c && grid[r1][c1+1] == 1)
                {
                    grid[r1][c1+1] = 2;
                    q.add((r1*c)+c1+1);
                }
            }
            minutes++;
        }
        if(minutes > 0)
            minutes--;
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        
        return minutes;
    }
}