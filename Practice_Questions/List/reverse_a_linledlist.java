package List;

import java.util.LinkedList;

public class reverse_a_linledlist {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);    
        list.add(4);
        list.add(5);
        System.out.println("Original list: " + list);
        // java.util.Collections.reverse(list);
        LinkedList<Integer> reversedList = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        System.out.println("Reversed list: " + reversedList);
    }
    
}
