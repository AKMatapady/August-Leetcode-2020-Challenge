class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() < 2)
            return true;
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray())
        {
            if(c >= 'A' && c<='Z')
            {
                sb.append(((char)(c+32))+"");
            }
            else if((c >= '0' && c <= '9') || (c >= 'a' && c<= 'z'))
                sb.append(c+"");
        }
        //System.out.println(sb.toString());
        int len = sb.length();
        int i = 0, j = len-1;
        while(i<j)
        {
            if(sb.charAt(i) != sb.charAt(j))
            {
                //System.out.println(sb.charAt(i) + ", " + sb.charAt(j));
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}