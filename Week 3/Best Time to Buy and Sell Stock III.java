class Solution {
    
    public static int recur(int [] prices, int count, int index, Integer[][] mem)
    {
        if (index == prices.length || count==2)
            return 0;

        if (mem[index][count] != null)
            return mem[index][count];

        int current = 0;
        for (int x = index+2; x<=prices.length;x++)
        {
            if (prices[index] < prices[x-1]){
                int price = prices[x-1] - prices[index];
                current = Math.max(current, price + recur(prices, count + 1, x , mem));
            }
        }
        current = Math.max(recur(prices, count, index + 1, mem), current);
        mem[index][count] = current;
        return mem[index][count];
    }
    
    public int maxProfit(int[] prices) 
    {
        Integer[][] mem = new Integer[prices.length+1][3];
        return recur(prices, 0, 0, mem);
    }
}