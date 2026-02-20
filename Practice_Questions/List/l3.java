package List;

public class l3 {
    Node head;
    
    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }    
    void append(int data) {
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

    void insert(int pos, int data) {
        Node newNode = new Node(data);
        
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        
        Node current = head;
        for (int i = 0; i < pos - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }
        
        newNode.next = current.next;
        current.next = newNode;
    }

    void delete(int data) {
        if (head == null) return;
        
        if (head.data == data) {
            head = head.next;
            return;
        }
        
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        
        if (current.next == null) {
            System.out.println("Data not found");
            return;
        }
        
        current.next = current.next.next;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void rotate(Node head, int k) {
        if (head == null || k <= 0) return;

        Node current = head;
        int count = 1;
        while (count < k && current != null) {
            current = current.next;
            count++;
        }

        if (current == null) return;

        Node kthNode = current;

        while (current.next != null) {
            current = current.next;
        }

        current.next = head;
        head = kthNode.next;
        kthNode.next = null;
    }
}
