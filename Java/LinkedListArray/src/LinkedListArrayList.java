import javafx.scene.control.Cell;

/**
 * Created by sameenislam on 01/05/2016.
 * An ArrayList Abstract Data Type (ADT) based on a LinkedList Data Structure (DS).
 */
public class LinkedListArrayList <E>{

    private Cell<E> myList;

    public LinkedListArrayList() {
        this.myList = null;
    }

    public void add(E item) {
        if(myList==null)
            myList = new Cell<E>(item,null);
        else {
            Cell<E> ptr = myList;
            for(; ptr.next!=null; ptr=ptr.next) {}
            ptr.next = new Cell<E>(item,null);
        }
    }

    public int size()
    {
        int count=0;
        for(Cell <E> ptr=myList; ptr!=null; ptr=ptr.next, count++) {}
        return count;
    }



    // Custom LinkedList implementation: 'Cell' (nested recursive class)
    private static class Cell<T> {
        T first;
        Cell<T> next;

        Cell(T head, Cell<T>n) {
            first = head;
            next = n;
        }
    }
}
