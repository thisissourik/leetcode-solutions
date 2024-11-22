import java.util.ArrayList;

public class PrintAllSubsequence {
    public static void main(String[] args) {
        int arr[] = {3, 1, 2};
        ArrayList<Integer> subsequence = new ArrayList<>();
        printAllSubsequence(0, arr, subsequence);
    }

    public static void printAllSubsequence(int idx, int arr[], ArrayList<Integer> lst) {
        // base case
        if (idx >= arr.length) {
            System.out.println(lst);
            return;
        }

        // take the index element
        lst.add(arr[idx]);
        printAllSubsequence(idx + 1, arr, lst);

        // leave the index element
        lst.remove(lst.size() - 1); // Remove the last element added
        printAllSubsequence(idx + 1, arr, lst);
    }
}
