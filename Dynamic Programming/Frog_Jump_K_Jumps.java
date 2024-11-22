public class Frog_Jump_K_Jumps {
    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 10 };
        int k = 2;

        int energyCost = frogJump(k, arr, arr);
        System.out.println(energyCost);
    }

    public static int frogJump(int k, int height[], int dp[]) {

        // base case
        if (k == 0)
            return 0;
        int minJump = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            // take jumps
            if (k > j) {
                int jump = frogJump(k - j, height, dp) + Math.abs(height[k] - height[k - j]);
                minJump = Math.min(minJump, jump);
            }
        }
        return minJump;

    }
}
