class WordDictionary {
    
    private class Node
    {
        public Node[] child;
        public boolean isEnd;
        public Node()
        {
            child = new Node[26];
            isEnd = false;
        }
    }
    
    private Node head;

    /** Initialize your data structure here. */
    public WordDictionary() {
        head = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node curr = head;
        for(char c: word.toCharArray())
        {
            if(curr.child[c - 'a'] == null)
                curr.child[c-'a'] = new Node();
            curr = curr.child[c-'a'];
        }
        curr.isEnd = true;
    }
    
    private boolean dfs(String word, int i, Node curr)
    {
        if(i >= word.length())
        {
            return curr.isEnd;
        }
        char ch = word.charAt(i);
        if(ch == '.')
        {
            for(int j = 0; j < 26; j++)
            {
                if(curr.child[j] != null && dfs(word, i+1, curr.child[j]))
                    return true;
            }
        }
        else
        {
            if(curr.child[ch-'a'] != null)
                return dfs(word, i+1, curr.child[ch-'a']);
                
        }
        return false;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word.length() < 1)
            return false;
        Node curr = head;
        int len = word.length();
        int i = 0;
        char ch = word.charAt(0);
        if(ch == '.')
        {
            for(int j = 0; j < 26; j++)
            {
                if(curr.child[j] != null && dfs(word, i+1, curr.child[j]))
                    return true;
            }
        }
        else
        {
            if(curr.child[ch-'a'] != null)
                return dfs(word, i+1, curr.child[ch-'a']);
                
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */