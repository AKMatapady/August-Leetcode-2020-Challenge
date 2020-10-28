class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int eachTurn = (num_people * (num_people+1))/2;
        long c = candies;
        long n = num_people;
        int turns = (int)((Math.sqrt(1+(8*c))-1.0)/(2*n));
        int rem = (int)(c-(((turns*turns*n*n)+(turns*n))/2));
        int[] ans = new int[num_people];
        //System.out.println("turns: "+turns);
        if(turns > 0)
        {
            for(int i = 0; i < num_people; i++)
            {
                ans[i] = (int)((i+1)*turns+(((turns*(turns-1))/2)*n));
            }
        }
        int i = 0;
        while(rem > 0 && i < num_people)
        {
            int curr = (int)((turns*n)+i+1);
            if(curr > rem)
            {
                ans[i]+=rem;
                break;
            }
            ans[i]+=curr;
            rem -= curr;
            i++;
            
        }
        return ans;
    }
}