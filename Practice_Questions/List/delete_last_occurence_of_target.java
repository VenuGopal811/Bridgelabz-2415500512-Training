package List;

public class delete_last_occurence_of_target {
    public static void main(String[] args) {
        Node n1 =new Node(0);
        Node n2=new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(3);
        Node n5 = new Node(2);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        int target=2;
        Node curr=n1;
        Node prev=null;
        while(curr!=null){
            if(curr.data==target){
                prev=curr;
            }
            curr=curr.next;
        }
        if(prev!=null){
            if(prev.next!=null){
                prev.data=prev.next.data;
                prev.next=prev.next.next;
            }else{
                if(prev==n1){
                    n1=null;
                }else{
                    curr=n1;
                    while(curr.next!=prev){
                        curr=curr.next;
                    }
                    curr.next=null;
                }
            }
        }
        Node print=n1;
        while(print!=null){
            System.out.print(print.data+" ");
            print=print.next;
        }
    }
}
