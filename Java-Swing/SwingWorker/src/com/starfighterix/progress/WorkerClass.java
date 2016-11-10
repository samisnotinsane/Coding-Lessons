package com.starfighterix.progress;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by sameen on 10/11/2016.
 */
public class WorkerClass extends SwingWorker<String, Double> {

    JProgressBar jProgressBar;
    JLabel jLabel;

    public WorkerClass(JProgressBar jProgressBar, JLabel jLabel) {
        this.jProgressBar = jProgressBar;
        this.jLabel = jLabel;
    }

    @Override
    protected String doInBackground() throws Exception {
        int maxNumber = 10;
        for(int i = 0; i < maxNumber; i++ ){
            Thread.sleep( 200 );//simulate long running process
            double factor = ((double)(i+1) / maxNumber);
            System.out.println("Intermediate results ready");
            publish(factor);//publish the progress
        }
        return "Finished";
    }

    @Override
    protected void process(List<Double> chunks) {
        Double latestFactor = chunks.get(chunks.size() - 1);
        //update the percentage of the progress bar that is done
        int amount = jProgressBar.getMaximum() - jProgressBar.getMinimum();
        jProgressBar.setValue( ( int ) (jProgressBar.getMinimum() + ( amount * latestFactor )) );
    }

    @Override
    protected void done() {
        try {
            jLabel.setText( get() );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        } catch ( ExecutionException e ) {
            e.printStackTrace();
        }
    }


}
