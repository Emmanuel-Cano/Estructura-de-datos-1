public class SinglyLinkedList {
    Node head;
    private int size;

    public void addLast(JobCustom data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            size = 1;
            return;
        }
        Node current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
        size++;
    }

    public JobCustom removeLast() {
        if (head == null) return null;
        if (head.next == null) {
            JobCustom val = head.data;
            head = null;
            size = 0;
            return val;
        }
        Node prev = head;
        while (prev.next.next != null) prev = prev.next;
        JobCustom val = prev.next.data;
        prev.next = null;
        size--;
        return val;
    }

    public boolean isEmpty() { return size == 0; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node cur = head;
        while (cur != null) {
            sb.append(cur.data);
            if (cur.next != null) sb.append(" -> ");
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
