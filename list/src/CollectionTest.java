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

    public static void main(String[] args) {
        AListTest();
        LListTest();
    }
}
