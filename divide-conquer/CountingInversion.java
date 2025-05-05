public class CountingInversion {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        System.out.println(countInversionDivideConquer(arr));
    }

    public static int countInversion(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length; j++)
                if (i < j && arr[i] > arr[j])
                    count++;
        return count;
    }

    public static int countInversionDivideConquer(int arr[], int i, int j, int count) {
        
    }
}
