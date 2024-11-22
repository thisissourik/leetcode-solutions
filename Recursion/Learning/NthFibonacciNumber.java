public class NthFibonacciNumber {
    public static void main(String[] args) {
        int num = 30;
        int arr[] = new int[num + 1];
        for (int i = 0; i < arr.length; i++)
            arr[i] = -1;
        int nthFibonacciNumber = getNthFibonacciNumber(num, arr);
        System.out.println(nthFibonacciNumber);
    }

    public static int getNthFibonacciNumber(int num, int arr[]) {
        if (num <= 1)
            return num;
        // dynamic approach
        if (arr[num] != -1)
            return arr[num];
        arr[num] = getNthFibonacciNumber(num - 1, arr) + getNthFibonacciNumber(num - 2, arr);
        return arr[num];
    }
}
