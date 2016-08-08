package main.java.com.sameen;

import weka.classifiers.functions.LibSVM;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.core.Utils.*;

/**
 * Created by Sameen on 08/08/2016 based on book by Jason Bell.
 * Basic code to get a support vector machine working in Weka.
 */

public class MLLibSVMTest {

    public MLLibSVMTest(String filepath) {
        Instances data;
        try {
            data = ConverterUtils.DataSource.read(filepath);
            if (data.classIndex() == -1)
                data.setClassIndex(data.numAttributes() - 1);
            LibSVM svm = new LibSVM();
            String[] options = weka.core.Utils.splitOptions("-K 0 -D 3 -split-percentage 10");
            svm.setOptions(options);
            svm.buildClassifier(data);
            showInstanceClassifications(svm, data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showInstanceClassifications(LibSVM svm, Instances data) {
        try {
            for(int i=0; i<data.numInstances(); i++) {
                System.out.println("Instance " + i + " is classified as a " +
                data.classAttribute().value((int)svm.classifyInstance(data.instance(i))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MLLibSVMTest mllsvm = new MLLibSVMTest("/Users/sameenislam/Documents/MachineLearning/SVM/MLLibSVM/src/main/java/com/sameen/vehicledata.arff");
    }
}
