import java.util.Iterator;

public interface List<T> extends Iterable<T> {
    static <T> void printList(List<T> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            T item = it.next();
            System.out.print(item + " ");
        }
    }

    /**
     * get the size of the List
     * @return size of the list
     */
    int size();

    /**
     * check if the List is empty
     * @return if the list is empty, return true, otherwise return false
     */
    boolean isEmpty();

    /**
     * clear the list
     */
    void clear();

    /**
     * check if the list contains x
     * @param x the item to be checked
     * @return if the list contains x, return true, otherwise return false
     */
    boolean contains(T x);

    /**
     * add x to the end of the list
     * @param x the item to be added
     * @return if successfully add x, return true, otherwise return false
     */
    boolean add(T x);

    /**
     * add item to position index of the list
     * @param index the index of the position
     * @param x the item to be added
     * @return if successfully added, return true, otherwise return false
     */
    boolean add(int index, T x);

    /**
     * remove x from the list
     * @param x the item to be removed
     * @return if x is successfully removed, return true, otherwise return false
     */
    boolean remove(T x);

    /**
     * get the item at specified index
     * @param index the index of the item to get
     * @return the item at the specified index
     */
    T get(int index);

    /**
     * set the item at index to elem
     * @param index the index of the item to change
     * @param elem the new item at the index
     */
    void set(int index, T elem);

    /**
     * @return an iterator of the list
     */
    java.util.Iterator<T> iterator();
}
