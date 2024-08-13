package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                broken.addLast(randVal);

            }
            else if (operationNumber == 1) {
                // size
                int size = L.size();
                int bsize = broken.size();
                assertEquals(size, bsize);
            }
            else if (operationNumber == 2) {
                if (L.size() == 0) {continue;}
                int last = L.getLast();
                int blast = broken.getLast();
                assertEquals(last, blast);
            }
            else if (operationNumber == 3) {
                if (L.size() == 0) {continue;}
                int last = L.removeLast();
                int blast = broken.removeLast();
                assertEquals(last, blast);
            }
        }
    }
}
