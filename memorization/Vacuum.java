package memorization;

import java.util.Iterator;
import java.util.LinkedList;

public class Vacuum {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        Iterator<Integer> iterator;
        ll.add(1);
        ll.add(2);
        iterator = ll.iterator();
        int i =  0;
        while(iterator.hasNext()){
            ++i;
            int data = iterator.next();
            System.out.printf("#%d %d\n", i, data);
        }
    }
}
