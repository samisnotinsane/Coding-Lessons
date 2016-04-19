/**
 * Created by sameenislam on 17/03/2016.
 */
public class HelloThread extends Thread{

    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        (new HelloThread()).start();
    }

}
