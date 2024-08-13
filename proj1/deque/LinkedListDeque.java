package deque;

public class LinkedListDeque<horse> {
    private int size;
    private IntNode sentinelf;
    private IntNode sentinelb;

    public class IntNode{
        public IntNode prev;
        public horse item;
        public IntNode next;

        public IntNode(IntNode prev, horse item, IntNode next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    public LinkedListDeque() {
        size = 0;
        sentinelf = new IntNode(null,null, null);
        sentinelb = new IntNode(sentinelf,null, null);
        sentinelf.next = sentinelb;
    }

    public void addFirst(horse T){
        size += 1;
        IntNode n = new IntNode(sentinelf, T, sentinelf.next);
        sentinelf.next.prev = n;
        sentinelf.next = n;
    }

    public void addLast(horse T){
        size += 1;
        IntNode n = new IntNode(sentinelb.prev, T, sentinelb);
        sentinelb.prev.next = n;
        sentinelb.prev = n;
    }
    public boolean isEmpty(){
        if (sentinelf.next == sentinelb){
            return true;
        }
        else{
            return false;
        }
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        IntNode curr = sentinelf.next;
        while (true){
            if (curr == sentinelb){
                System.out.println();
                break;
            }
            if(curr != null){
                System.out.print(curr.item + " ");
            }
            else{
                System.out.print("  ");
            }
            curr = curr.next;
        }
    }

    //remove first
    public horse removeFirst(){
        if (sentinelf.next.next != null) {
            horse get = sentinelf.next.item;
            // clean the first ? maybe .next = null
            sentinelf.next.item = null;
            sentinelf.next = sentinelf.next.next;
            sentinelf.next.prev = sentinelf;
            size -= 1;
            return get;
        }
        return null;
    }

    //remove last
    public horse removeLast(){
        if (sentinelb.prev.prev != null){
            horse get = sentinelb.prev.item;
            // clean the last ? maybe .prev = null
            sentinelb.prev.item = null;
            sentinelb.prev = sentinelb.prev.prev;
            sentinelb.prev.next = sentinelb;
            size -= 1;
            return get;
        }
        return null;

    }

    // get

    public horse get(int index){
        IntNode curr = sentinelf;
        for (int i = 0; i <= index; i ++) {
            curr = curr.next;
            if (curr == sentinelb){
                return null;
            }
        }
        return curr.item;
    }
}
