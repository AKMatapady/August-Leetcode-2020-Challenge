/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int x = rand7();
        int y = rand7();
        int val = x+((y-1)*7);
        while(val>40)
        {
            x = rand7();
            y = rand7();
            val = x+((y-1)*7);
        }
        return 1+((val-1)%10);
    }
}