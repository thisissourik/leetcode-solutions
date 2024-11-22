public class L3 {
    public static void main(String args[]) {
        int N = 10;
        // parameterizedRec(N, 0);
        // int sum = funtionalRec(N);
        // System.out.println(sum);
        int fact = factorial(5);
        System.out.println(fact);

    }

    public static int funtionalRec(int N) {
        if (N == 0)
            return 0;
        return N + funtionalRec(N - 1);
    }

    public static void parameterizedRec(int N, int sum) {
        if (N == 0) {
            System.out.println(sum);
            return;
        }
        parameterizedRec(N - 1, sum + N);

    }

    public static int factorial(int N) {
        if (N <= 1)
            return 1;
        return N *
                factorial(N - 1);

    }
}