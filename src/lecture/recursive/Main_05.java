package lecture.recursive;

public class Main_05 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.lt);
        preorder(root.rt);
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.lt);
        System.out.print(root.data + " ");
        inorder(root.rt);
    }

    public static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.lt);
        postorder(root.rt);
        System.out.print(root.data + " ");
    }

    private static class Node {
        int data;
        Node lt;
        Node rt;

        public Node(int data) {
            this.data = data;
        }
    }

}
