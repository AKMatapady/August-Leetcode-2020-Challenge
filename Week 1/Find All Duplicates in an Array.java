class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        int len = nums.length;
        for(int i = 0; i < nums.length; i++)
        {
            nums[(nums[i]%len)-1] += len;
        }
        for(int i = 0; i < nums.length; i++)
        {
            //System.out.println();
            int x = nums[nums[i]-1];
            nums[nums[i]-1] = nums[i];
            nums[i] = x;
            // for(int y: nums)
            // System.out.print(y+ " ");
        }
        // System.out.println();
        // for(int x: nums)
        // System.out.print(x+ " ");
        for(int i = 0; i < nums.length; i++)
        {
           if(nums[i]!=(i+1))
               ans.add(nums[i]);
        }
        return ans;
    }
}