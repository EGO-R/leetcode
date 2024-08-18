package neetcode.medium.copy_list_with_random_pointer;

public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "[" + val + ", " + random + "] " + next;
    }
}
