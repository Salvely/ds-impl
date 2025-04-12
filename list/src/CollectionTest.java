import java.util.ArrayList;
import java.util.Stack;

public class CollectionTest {
    public static void AListTest() {
        AList<Integer> alist = new AList<>(5);
        for(int i = 0; i < 5; i++) {
            alist.add(i);
            List.printList(alist);
            System.out.println();
        }
        for(int i = 5; i < 10; i++) {
            alist.add(i);
            List.printList(alist);
            System.out.println();
        }
    }

    public static void LListTest() {
        AList<Integer> llist = new AList<>(5);
        for(int i = 0; i < 5; i++) {
            llist.add(i);
            List.printList(llist);
            System.out.println();
        }
        for(int i = 5; i < 10; i++) {
            llist.add(i);
            List.printList(llist);
            System.out.println();
        }
    }

    public static void printLots(ArrayList<Integer> L, Stack<Integer> P) {
        int index = 1;
        for(int elem: L) {
            if(P.isEmpty()) {
                break;
            }
            if(index == P.peek()) {
                P.pop();
                System.out.print(elem + " ");
            }
            index++;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> L = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            L.add(i);
        }
        Stack<Integer> P = new Stack<>();
        P.add(6);
        P.add(4);
        P.add(3);
        P.add(1);
        printLots(L,P);
    }
}
