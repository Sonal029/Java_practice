package Question3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadOperations
{
    private final static int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private final List<Integer> intList = List.of(1, 2, 3, 4, 15, 6, 7, 10, 12, 20);

    public static void reverseArray() {
        for (int i = 0; i < 5; i++) {
            int temp = intArray[i];
            intArray[i] = intArray[9 - i];
            intArray[9 - i] = temp;
            System.out.println("Swapping " + temp + ", " + intArray[i]);
        }
        System.out.println(Arrays.toString(intArray));
    }

    public void findNearestToAverage() {
        double avg = intList.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        int nearest = intList.get(0);
        double diff = Math.abs(avg - nearest);

        for (int i = 1; i < intList.size(); i++) {
            double newDiff = Math.abs(avg - intList.get(i));
            if (newDiff < diff) {
                nearest = intList.get(i);
                diff = newDiff;
            }
        }
        System.out.println("Average is " + avg + " Element nearest to average is " + nearest);
    }

    public static void main(String[] args) throws InterruptedException {
        RunThread rt1 = ThreadOperations::reverseArray;
        ThreadOperations to = new ThreadOperations();
        RunThread rt2 = to::findNearestToAverage;

        List<Thread> threadList = new ArrayList<>();
        threadList.add(new Thread(() -> rt1.startThread(Thread.currentThread())));
        threadList.add(new Thread(() -> rt2.startThread(Thread.currentThread())));

        for (Thread t : threadList) {
            t.start();
        }

        for (Thread t : threadList) {
            t.join();
        }

        Thread.sleep(500);
        System.out.println("Main thread finished");
    }
}

@FunctionalInterface
interface RunThread {
    void startThread(Thread t);
}

