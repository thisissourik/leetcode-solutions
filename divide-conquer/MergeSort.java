public class MergeSort {
    public static void main(String[] args) {
        // int arr[] = { 78, 98, 56, 74, 12 };
        int arr[] = { 78, 98, 56, 74, 12, -1, 254, 544, 100, 159, 354, 28, 12, 300, 312, 1445, 758 };

        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void mergeSort(int arr[], int i, int j) {
        if (i == j)
            return;

        int mid = (i + j) / 2;
        mergeSort(arr, i, mid);
        mergeSort(arr, mid + 1, j);
        merge(arr, i, mid, j);
    }

    public static void merge(int arr[], int i, int mid, int j) {
        int p = i;
        int q = mid + 1;
        int k = 0;

        int merged[] = new int[j - i + 1];

        while (p <= mid && q <= j) {
            if (arr[p] < arr[q]) {
                merged[k] = arr[p];
                p++;
            } else {
                merged[k] = arr[q];
                q++;
            }
            k++;
        }
        // copy 2nd half
        while (q <= j)
            merged[k++] = arr[q++];
        // copy 1st half
        while (p <= mid)
            merged[k++] = arr[p++];

        for (k = 0; k < merged.length; k++)
            arr[i+k] = merged[k];
    }
}
