package Question5;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        Thread t1 = new Thread(new MyRunnable(a, "Sonal"));
        Thread t2 = new Thread(new MyRunnable(a, "Manish"));
        Thread t3 = new Thread(new MyRunnable(a, "Rohan"));
        t1.start();
        t2.start();
        t3.start();
    }
}

class MyRunnable implements Runnable {
    private final A a;
    private final String name;

    public MyRunnable(A a, String name) {
        this.a = a;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (a) {
            a.sayHello(name);
        }
    }
}

class A {
    public void sayHello(String name) {
        System.out.print("Welcome: ");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(name);
    }
}
 