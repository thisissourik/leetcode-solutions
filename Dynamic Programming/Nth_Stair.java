/*
 * 
 * 
 * You have been given a number of stairs. Initially, you are at the 0th stair,
 * and you need to reach the Nth stair.
 * 
 * Each time, you can climb either one step or two steps.
 * 
 * You are supposed to return the number of distinct ways you can climb from the
 * 0th step to the Nth step.
 * 
 * Example :
 * N=3
 * We can climb one step at a time i.e. {(0, 1) ,(1, 2),(2,3)} or we can climb
 * the first two-step and then one step i.e. {(0,2),(1, 3)} or we can climb
 * first one step and then two step i.e. {(0,1), (1,3)}.
 */
public class Nth_Stair {
    public static void main(String[] args) {
        int N = 4;
        int dp[] = new int[N + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i] = -1;

        int count = countDistinctWayToClimbStair(N, dp);
        System.out.println(count);

    }

    public static int countDistinctWayToClimbStair(int n, int dp[]) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        int left = countDistinctWayToClimbStair(n - 1, dp);
        int right = countDistinctWayToClimbStair(n - 2, dp);

        dp[n] = left + right;
        return dp[n];
    }
}