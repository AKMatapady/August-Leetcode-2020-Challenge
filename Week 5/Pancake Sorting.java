class Solution {
    
    //number -> index
    private HashMap<Integer, Integer> mp;
    //index -> number
    private HashMap<Integer, Integer> mp2;
    
    private void swap(int end)
    {
        end--;
        for(int i = 0; i <= (end/2); i++)
        {
            int num1 = mp2.get(i);
            int num2 = mp2.get(end-i);
            mp.put(num1, end-i);
            mp2.put(end-i, num1);
            mp.put(num2, i);
            mp2.put(i, num2);
        }
    }
    
    
    
    public List<Integer> pancakeSort(int[] A) {
        
        List<Integer> ans  = new ArrayList<Integer>();
        if(A == null || A.length < 2)
            return ans;
        
        int prev = A[0];
        boolean sorted = true;
        int len = A.length;
        
        for(int i = 1; i < len; i++)
        {
            if(prev > A[i])
            {
                sorted = false;
                break;
            }
            prev = A[i];
        }
        if(sorted)
            return ans;
        
        //number -> index
        mp = new HashMap<Integer, Integer>();
        mp2 = new HashMap<Integer, Integer>();
        for(int i = 0; i < len; i++)
        {
            mp.put(A[i], i);
            mp2.put(i, A[i]);
        }
        int k = len;
        int num = 1;
        while(k > 0)
        {
            int curr = mp.get(num);
            System.out.println(num + " " + curr + " " + (k-1));
            if(curr == (k-1))
            {
                num++;
                k--;
                continue;
            }
            ans.add(curr+1);
            ans.add(k);
            
            swap(curr+1);
            swap(k);
            
            k--;
            num++;
            
        }
        ans.add(len);
        return ans;
    }
}