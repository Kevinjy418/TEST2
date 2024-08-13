package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;
public class testThreeAddThreeRemove {

    @Test
    public void testThreeAddThreeRemove() {
        BuggyAList<Integer> B = new BuggyAList<Integer>();
        AListNoResizing<Integer> A = new AListNoResizing<Integer>();
        // add 4
        B.addLast(4);
        A.addLast(4);
        // add 5
        B.addLast(5);
        A.addLast(5);
        // add 6
        B.addLast(6);
        A.addLast(6);

        assertEquals(B.removeLast(), A.removeLast());
        assertEquals(A.removeLast(), B.removeLast());
        assertEquals(B.removeLast(), A.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                System.out.println("size: " + size);
            }
        }
    }

}
