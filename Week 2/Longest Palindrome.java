class Solution {
    public int longestPalindrome(String s) {
        
        if(s == null || s.length() < 1)
            return 0;
        
        if(s.length() == 1)
            return 1;
        
        HashMap<Character, Integer> mp = new HashMap<Character, Integer>();
        int len = s.length();
        
        for(int i = 0; i < len; i++)
        {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0)+1);
        }
        
        if(len == mp.keySet().size())
            return 1;
        
        int count = 0;
        boolean odd = false;
        
        for(char key: mp.keySet())
        {
            int freq = mp.get(key);
            if(freq%2==0)
            {
                count += freq;
            }
            else
            {
                odd = true;
                count += (freq-1);
            }
        }
        if(odd)
            count++;
        return count;        
    }
}