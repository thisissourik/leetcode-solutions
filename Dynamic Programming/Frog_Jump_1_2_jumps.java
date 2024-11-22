public class Frog_Jump_1_2_jumps {
    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 10 };
        int dp[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            dp[i] = -1;

        int energyCost = frogJump(arr.length - 1, arr, dp);
        System.out.println(energyCost);

        for (int i : dp)
            System.out.println(i);
    }

    public static int frogJump(int n, int height[], int dp[]) {
        // Step 1 : energy to jump from 0 to 0 is 0
        if (n == 0)
            return 0;
        // check if given condition is solved earlier
        if (dp[n] != -1)
            return dp[n];
        // step 2 : opt 1 : Jumping one stair
        int jumpOne = frogJump(n - 1, height, dp) + Math.abs(height[n] - height[n - 1]);

        // step 2 : opt 2 : Jumping two stair - only possible if n > 1
        int jumpTwo = Integer.MAX_VALUE;
        if (n > 1)
            jumpTwo = frogJump(n - 2, height, dp) + Math.abs(height[n] - height[n - 2]);
        // step 3 : return the minimum of two jump
        dp[n] = Math.min(jumpOne, jumpTwo);
        return dp[n];
    }
}
