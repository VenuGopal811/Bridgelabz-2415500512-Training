package List;

//Create a node and make a list of 5 nodes and print the list
public class l1 {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();       
        second.next = fourth;
        third.next = fifth;
        fourth.next = third;
        node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}