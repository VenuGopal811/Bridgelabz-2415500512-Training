package List;

public class l4 {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        head.next = second;
        second.next = third;
        third.next = head; 
        
        Node curr = head;
        while (curr.next !=null && curr.next!=head){
            curr=curr.next;
            if(curr==head){
                System.out.println(true);
            }

        }
        System.out.println(false);
    }
    
}
