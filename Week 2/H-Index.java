class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length < 1)
            return 0;
        if(citations.length == 1)
            return (citations[0] > 0)?1:0;
        Arrays.sort(citations);
        int len = citations.length;
        int i = 0, h = 0;
        for(int j = len-1; j >=0; j--)
        {
            i++;
            if(citations[j] >= i)
                h = i;
            else
                break;
        }
       return h; 
    }
}