import java.util.Stack;

public class NextGreaterElement1 {
    public static void main(String[] args) {
        int arr[] = { 4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6 };
        int[] NGE1 = nextGreaterElementI(arr);
        for (int i : NGE1) {
            System.out.println(i);
        }
    }

    public static int[] nextGreaterElementI(int arr[]) {
        int result[] = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty())
                result[i] = -1;
            else
                result[i] = stack.peek();
            stack.push(arr[i]);
        }
        return result;

    }
}
