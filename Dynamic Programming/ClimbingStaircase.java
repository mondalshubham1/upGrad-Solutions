public class ClimbingStaircase {
    static int numOfWays(int N)

    {

        if(N==0)

            return 0;

        int[] dp = new int[N];

        dp[0] = 1;

        dp[1] = 2;

        for(int i=2; i<dp.length; i++)

        {

            dp[i] = dp[i-1] + dp[i-2];

        }

        return dp[N-1];

    }
    public static void main(String args[])
    {
        int n=15;
        System.out.println(numOfWays(n));
    }
}
