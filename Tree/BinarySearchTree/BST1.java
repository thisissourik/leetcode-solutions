public class BST1 {
    public static void main(String[] args) {
        int data[] = { 10, 9, 25, 65, 7, 8, 16 };
        Node head = null;
        for (int i : data)
            head = insert(head, i);
        // inorder(head);
        // preorder(head);
        // postorder(head);
    }

    public static Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);
        if (data < root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);
        return root;
    }

    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static void preorder(Node root) {
        if (root == null)
            return;
        preorder(root.left);
        preorder(root.right);
        System.out.println(root.data);
    }

    public static void postorder(Node root) {
        if (root == null)
            return;
        postorder(root.right);
        postorder(root.left);
        System.out.println(root.data);
    }

    public static void BFS() {
    }

    public static void DFS() {
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node() {

    }

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}