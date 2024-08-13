package deque;

public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int next_first;
    private int next_last;
    public ArrayDeque(){
        items = (Item[]) new Object[8];
        size = 0;
        next_first = items.length - 1;
        next_last = 0;
    }

    private void resize(int capacity){
        Item [] newItems = (Item[]) new Object[capacity];
        for (int i = 1; i < size; i ++){
            newItems[i] = items[(++ next_first) % items.length];
        }
        next_first = 0;
        next_last = size + 1;
        items = newItems;
    }
    public void addFirst(Item T){

        if (size == items.length){
            resize(items.length * 2);
        }
        items[next_first] = T;
        next_first = next_first == 0 ? items.length - 1 : next_first - 1;
        size += 1;
    }

    public void addLast(Item T){
        // full
        if (size == items.length){
            resize(items.length * 2);
        }
        items[next_last] = T;
        next_last = (next_last + 1) % items.length;
        size += 1;
    }
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public Item removeFirst(){
        // clean
        if (size == 0){return null;}
        next_first = (next_first + 1) % items.length;
        Item temp = items[next_first];
        items[next_first] = null;
        size --;
        if (items.length >= 16 && size < (items.length / 4)){
            resize(items.length / 2);
        }
        return temp;

    }

    public Item removeLast(){
        if (size == 0){return null;}
        next_last = next_last == 0 ? items.length - 1 : next_last - 1;
        Item temp = items[next_last];
        items[next_last] = null;
        size --;
        if (items.length >= 16 && size < (items.length / 4)){
            resize(items.length / 2);
        }
        return temp;
    }

    public Item get(int index){
        Item temp = items[(next_first + index + 1) % items.length];
        return temp;
    }

    public void printDeque(){
        for (int i = 0; i < size; i ++){
            System.out.println(items[(++ next_first) % items.length] + " ");
        }
    }
}

