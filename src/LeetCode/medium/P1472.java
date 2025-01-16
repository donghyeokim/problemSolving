package LeetCode.medium;

public class P1472 {
    public class Node {
        String url;
        Node prev;
        Node next;

        public Node(String url) {
            this.url = url;
        }
    }

    Node cursor;

    public P1472(String homepage) {
        cursor = new Node(homepage);
    }

    public void visit(String url) {
        Node next = new Node(url);
        cursor.next = next;
        next.prev = cursor;
        cursor = next;
    }

    public String back(int steps) {
        while(cursor.prev != null && --steps >= 0)
            cursor = cursor.prev;
        return cursor.url;
    }

    public String forward(int steps) {
        while(cursor.next != null && --steps >= 0)
            cursor = cursor.next;
        return cursor.url;
    }
}
