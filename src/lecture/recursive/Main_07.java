package lecture.recursive;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main_07 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        bfs(root);
    }

    private static void bfs(Node root) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        int L = 0;
        while (!deque.isEmpty()) {
            int len = deque.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                Node cur = deque.remove();
                System.out.print(cur.data + " ");
                if (cur.lt != null) {
                    deque.add(cur.lt);
                }
                if (cur.rt != null) {
                    deque.add(cur.rt);
                }
            }
            L++;
            System.out.println();
        }
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
