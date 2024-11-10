import java.util.Stack;

public class LongestValidParanthesis {
    public static void main(String[] args) {
        String s = ")()())";
        String s1 = "(()";
        String s2 = "()(()";
        String s3 = ")())(()()(()";
        int longestValidParentheses = longestValidParentheses(s3);
        System.out.println(longestValidParentheses);
    }

    public static int longestValidParentheses(String s) {
        // we insert -1 at stack to serve as base position
        // if we get '(' -> push index position to stack
        // if we get ')' and stack is not empty -> valid paranthesis , calcuate length
        // if we get ')' and stack is empty -> invalid paranthesis and we push its index
        // to serve as base for the next calculation
        Stack<Integer> stack = new Stack<Integer>();
        int greatestLen = 0;
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(')
                stack.push(i); // Push the index of '(' onto the stack
            else {
                stack.pop();// Pop for matching ')'
                if (stack.isEmpty()) {
                    stack.push(i);// Push current index as the base for the next valid sequence
                } else
                    // Calculate the length of the current valid substring
                    greatestLen = Math.max(greatestLen, i - stack.peek());
            }
        }
        return greatestLen;
    }
}