package List;

public class mid_of_list {
    public static void main(String[] args) {
        Node n1 =new Node(0);
        Node n2=new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(3);
        Node n5 = new Node(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        Node curr=n1;
        int n=0;

        while(curr!=null){
            n++;
            curr=curr.next;
        }
        curr=n1;
        int mid=n/2;
        for(int i=0;i<mid;i++){
            curr=curr.next;
        }
        System.out.println(curr.data);
    }
    
}
