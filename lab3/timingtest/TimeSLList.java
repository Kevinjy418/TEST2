package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        // AList for Ns
        AList<Integer> Ns = new AList<>();
        for (int i = 1000; i <= 128000; i *= 2) {
            Ns.addLast(i);
        }

        // AList for times, it will
        AList<Double> times = new AList<>();
        for (int i = 1000; i <= 128000; i *= 2) {
            SLList<Integer> mode = new SLList<>();
            for (int j = 0; j <= i; j ++) {
                mode.addLast(1);
            }
            Stopwatch sw = new Stopwatch();
            for(int j = 0; j <= 10000; j ++) {
                int x = mode.getLast();
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }
        // AList for opCounts
        AList<Integer> op = new AList<>();
        for (int i = 0; i < 8; i ++) {
            op.addLast(10000);
        }

        printTimingTable(Ns, times, op);
    }

}
