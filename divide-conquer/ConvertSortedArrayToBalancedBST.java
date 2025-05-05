public class ConvertSortedArrayToBalancedBST {
    public static void main(String[] args) {
        int arr[] = { -10, -3, 0, 5, 9 };
        TreeNode root = sortedArrayToBST(arr);
        inorder(root); // Print the tree once after full construction
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildBST(nums, 0, nums.length - 1);
    }

    public static TreeNode buildBST(int nums[], int left, int right) {
        if (left > right)
            return null;

        int mid = left + (right - left) / 2; // Avoids overflow
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildBST(nums, left, mid - 1); // Corrected: Use 'left' instead of '0'
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }

    public static void inorder(TreeNode head) {
        if (head == null)
            return;
        inorder(head.left);
        System.out.print(head.val + " ");
        inorder(head.right);
    }
}

class TreeNode {
    int val;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}