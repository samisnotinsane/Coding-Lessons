// sleeps for 4 secs and prints an element from the string array.
public class SleepMessages implements Runnable {
    
    public void run() {

        String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };

        for (int i = 0;
             i < importantInfo.length;
             i++) {
            //Pause for 4 seconds
            try {
            Thread.sleep(4000);
            } catch(InterruptedException e) {return;}
            //Print a message
            System.out.println(importantInfo[i]);
        }
    }    

    public static void main(String args[])
        {
        
            Thread t1 = new Thread();
            t1.start();
        
    }
}
