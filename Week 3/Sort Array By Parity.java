class Solution {
    public int[] sortArrayByParity(int[] A) {
        int len = A.length;
        int i = 0, j = len-1;
        while(i<j)
        {
            while(i < j && A[i]%2==0)
            {
                i++;
            }
            while(i < j && A[j]%2!=0)
            {
                j--;
            }
            if(i < j && A[i]%2==1 && A[j]%2==0)
            {
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
                
            }
        }
        return A;
    }
}