class CombinationIterator {
    
    public Stack<String> st = new Stack <String>();

    public CombinationIterator(String characters, int combinationLength) {
        int n = characters.length();
        int k = combinationLength; 
        for (int bitmask = 0; bitmask < 1 << n; bitmask++) 
        {
            if (Integer.bitCount(bitmask) == k) 
            {
                StringBuilder curr = new StringBuilder();
                for (int j = 0; j < n; j++) 
                {
                    if ((bitmask & (1 << n - j - 1)) != 0) 
                    {
                        curr.append(characters.charAt(j));
                    }
                }
                st.push(curr.toString());
            }
        }
    }
    
    public String next() {
        return st.pop();
    }
    
    public boolean hasNext() {
        return (!st.isEmpty());
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */