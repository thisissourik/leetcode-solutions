public class ReverseAnArray {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 2 };
        System.out.println("Original Array");
        for (int i : arr)
            System.out.print(i + "\t");
        System.out.println();
        System.out.println("Reversed Array");
        // reverseArray(arr, 0, arr.length - 1);
        // reverseArrayOnePtr(arr, 0);
        for (int i : arr)
            System.out.print(i + "\t");
        System.out.println();
    }

    public static void reverseArrayOnePtr(int arr[], int ptr) {
        if (ptr == arr.length - ptr - 1)
            return;
        int t = arr[ptr];
        arr[ptr] = arr[arr.length - ptr - 1];
        arr[arr.length - ptr - 1] = t;
        reverseArrayOnePtr(arr, ptr + 1);
    }

    public static void reverseArray(int arr[], int s, int e) {
        // Base condition
        if (s == e)
            return;
        // swap
        int t = arr[s];
        arr[s] = arr[e];
        arr[e] = t;
        // call the next
        reverseArray(arr, s + 1, e - 1);
    }
}
