class Solution {
    
    private void union(int n, int m, Map<Integer,Integer> p) {
        int findN = find(n,p);
        int findM = find(m,p);
        if (findN < findM) p.put(findM,findN);
        else p.put(findN,findM);
    }

    private int find(Integer i, Map<Integer,Integer> p) {
        if (p.get(i) == null) p.put(i,i);
        while (i != p.get(i)) i = p.get(i);
        return i;
    }
    
    private int hcf(int x, int y)
    {
        if(x == 0)
            return y;
        if(y == 0)
            return x;
        return hcf(y%x, x);
    }
    
    private boolean hasCommonFactor(int x, int y)
    {
        int cf = hcf(x,y);
        if(cf > 1)
            return true;
        return false;
    }
    
    public int largestComponentSize(int[] A) {
        if(A == null || A.length < 1)
            return 0;
        if(A.length == 1)
            return 1;
        
        //integer -> parent
        Map<Integer,Integer> p = new HashMap<>();

        for (int num : A)
            for (int fact = 2; fact*fact<=num; fact++)
                if (num % fact == 0){
                    union(num,fact,p);
                    union(num,num/fact,p);
                }

        int max = 1;
        Map<Integer,Integer> freq = new HashMap<>();
        for (Integer v : A) {
            int f = find(v,p);
            if (freq.containsKey(f)) {
                freq.put(f, freq.get(f)+1);
                max=Math.max(max,freq.get(f));
            }
            else freq.put(f,1);
        }
        return max;
    }
}