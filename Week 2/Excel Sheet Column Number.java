class Solution {
    public int titleToNumber(String s) {
        int len = s.length();
        
        if(len == 1)
        {
            return (s.charAt(0)-'A'+1);
        }
        
        int n = 0;
        int i;
        for(i = 1; i < len; i++)
        {
            n+= (int)Math.pow(26, i);
        }
        int prod = 1;
        for(i = 0; i < len; i++)
        {
            prod += (int)(Math.pow(26, (len-1-i)) * (s.charAt(i)-'A'));
        }
        return n + prod;
    }
}