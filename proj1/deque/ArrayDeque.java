package deque;
import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;
    private int next_First;
    private int next_Last;

    public class ArrayDequeIterator implements Iterator<T>{
        private int wizpos;

        private ArrayDequeIterator(){
            wizpos = 0;
        }
        @Override
        public boolean hasNext(){
            return wizpos < size;
        }
        @Override
        public T next(){
            T item = items[wizpos];
            wizpos ++;
            return item;
        }
    }

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        next_First = items.length - 1;
        next_Last = 0;
    }

    private void resize(int capacity){
        T [] newItems = (T[]) new Object[capacity];
        for (int i = 1; i < size; i ++){
            newItems[i] = items[(++next_First) % items.length];
        }
        next_First = 0;
        next_Last = size + 1;
        items = newItems;
    }
    public void addFirst(T T){

        if (size == items.length){
            resize(items.length * 2);
        }
        items[next_First] = T;
        next_First = next_First == 0 ? items.length - 1 : next_First - 1;
        size += 1;
    }

    public void addLast(T T){
        // full
        if (size == items.length){
            resize(items.length * 2);
        }
        items[next_Last] = T;
        next_Last = (next_Last + 1) % items.length;
        size += 1;
    }

    public int size(){
        return size;
    }

    public T removeFirst(){
        // clean
        if (size == 0){return null;}
        next_First = (next_First + 1) % items.length;
        T temp = items[next_First];
        items[next_First] = null;
        size --;
        if (items.length >= 16 && size < (items.length / 4)){
            resize(items.length / 2);
        }
        return temp;

    }

    public T removeLast(){
        if (size == 0){return null;}
        next_Last = next_Last == 0 ? items.length - 1 : next_Last - 1;
        T temp = items[next_Last];
        items[next_Last] = null;
        size --;
        if (items.length >= 16 && size < (items.length / 4)){
            resize(items.length / 2);
        }
        return temp;
    }

    public T get(int index){
        T temp = items[(next_First + index + 1) % items.length];
        return temp;
    }

    public void printDeque(){
        for (int i = 0; i < size; i ++){
            System.out.println(items[(++next_First) % items.length] + " ");
        }
    }

    // this is a method. When I call it,it should return me an iterator
    public Iterator<T> iterator(){
        return new ArrayDequeIterator();
    }



    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Deque)) {
            return false;
        }
        Deque<T> oa = (Deque<T>) o;
        if (oa.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < size; i += 1) {
            if (!(oa.get(i).equals(this.get(i)))) {
                return false;
            }
        }
        return true;
    }
}

