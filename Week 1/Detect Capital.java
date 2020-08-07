class Solution {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for(char c: word.toCharArray())
        {
            if(c >= 'A' && c<='Z')
                count++;
        }
        if(count == 0)
            return true;
        if(count == word.length())
            return true;
        if(count == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z')
            return true;
        return false;
    }
}