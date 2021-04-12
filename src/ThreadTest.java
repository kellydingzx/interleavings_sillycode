import java.util.ArrayList;

public class ThreadTest {
    private static volatile int x;

    public static void main(String[] args)  {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();
    }

    static class Thread1 extends Thread{
        public void run(){
            synchronized (this) {
                x = 100;
                System.out.println("1: "+ x);
            }
            synchronized (this) {
                System.out.println("2a: "+ x);
            }
            synchronized (this) {
                x += 10;
                System.out.println("2b: "+ x);
            }
        }
    }

    static class Thread2 extends Thread{
        public void run(){
            synchronized (this) {
                x = 200;
                System.out.println("3: "+ x);
            }
            synchronized (this) {
                System.out.println("4a: "+ x);
            }
            synchronized (this) {
                x -= 20;
                System.out.println("4b: "+ x);
            }
        }
    }
}
