/**
 * Created by sameenislam on 17/03/2016.
 */
public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from a thread!");
    }

    public void hey() {
        System.out.println("Hey");
    }

    public static void main(String args[]) {
        new Thread(new HelloRunnable()).start();
        //new HelloRunnable().hey();
    }
}
