package List;

public class l2 {
    static void append(Node head, int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            return;
        }
        
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        append(head, 2);
        append(head, 3);

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
