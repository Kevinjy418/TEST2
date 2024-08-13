package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        // AList for Ns
        AList<Integer> Ns = new AList<>();
        for (int i = 1000; i <= 128000; i *= 2) {
            Ns.addLast(i);
        }

        // AList for times, it will
        AList<Double> times = new AList<>();
        for (int i = 1000; i <= 128000; i *= 2) {
            Stopwatch sw = new Stopwatch();
            AList<Integer> mode = new AList<>();
            for (int j = 0; j <= i; j ++) {
                mode.addLast(j);
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }
        // AList for opCounts
        AList<Integer> op = new AList<>();
        op = Ns;
        printTimingTable(Ns, times, op);
    }
}
