/**
 * Created by sameenislam on 17/03/2016.
 */
public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        new Thread(new HelloRunnable()).start();
    }
}
