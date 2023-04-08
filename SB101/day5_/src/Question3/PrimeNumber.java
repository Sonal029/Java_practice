package Question3;

public class PrimeNumber extends Thread {
    private final int start;
    private final int end;

    public PrimeNumber(String name, int start, int end, int priority) {
        super(name);
        this.start = start;
        this.end = end;
        setPriority(priority);
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.println(getName() + ": " + i);
            }
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}


