public class ExponentialPower {
    public static void main(String[] args) {
        int base = 3;
        int power = 0;
        System.out.println(power(base, power));
    }

    public static int power(int b, int p) {
        if (p == 0)
            return 1;
        if (p == 1)
            return b;
        if (p % 2 == 0)
            return power(b, p / 2) * power(b, p / 2);
        else
            return b * power(b, p / 2) * power(b, p / 2);
    }
}
