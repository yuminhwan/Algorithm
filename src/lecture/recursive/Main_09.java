package lecture.recursive;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main_09 {

    static Node root;

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(dfs(0, root));
        System.out.println(bfs(root));
    }

    private static int dfs(int L, Node root) {
        if (root.lt == null && root.rt == null) {
            return L;
        }
        return Math.min(dfs(L + 1, root.lt), dfs(L + 1, root.rt));
    }

    private static int bfs(Node root) {
        Deque<Node> q = new ArrayDeque<>();
        q.add(root);
        int answer = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node next = q.remove();
                if (next.rt == null && next.lt == null) {
                    return answer;
                }
                if (next.lt != null) {
                    q.add(next.lt);
                }
                if (next.rt != null) {
                    q.add(next.rt);
                }
            }
            answer++;
        }
        return answer;
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
