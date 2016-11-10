package main.java.com.starfighterix.game.engine;

import javax.swing.*;

public class Main extends JFrame {

    private long fps;
    boolean isRunning;

    public static void GameTutorial (String[] args) {
	// write your code here
    }

    /**
     * This method starts the game and runs it in a loop
     */
    public void run() {

        initialise();

        while(isRunning) {
            long time = System.currentTimeMillis();

            update();
            draw();

            //  delay for each frame  -   time it took for one frame
            time = (1000 / fps) - (System.currentTimeMillis() - time) ;

            if (time > 0) {
                try
                {
                    Thread.sleep(time);
                }
                catch(Exception e){}
            }
        }
        setVisible(false);

    }

    /**
     * This method will set up everything need for the game to run
     */
    void initialise() {

    }

    /**
     * This method will check for input, move things
     * around and check for win conditions, etc
     */
    void update() {

    }


    /**
     * This method will draw everything
     */
    void draw() {

    }

}
