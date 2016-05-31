import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BooleanSupplier;

/**
 * Created by sameenislam on 02/05/2016.
 */
public class Main {

    public static void main(String[] args) {
        int[] acNos = {1,2,5,2,10};
        ArrayList<Account> accountArrayList = new ArrayList<>();

        for(int i=0; i<acNos.length; i++ ) {
            accountArrayList.add(new Account(acNos[i]));
        }

        // now detect duplicates
        System.out.println("noDuplicates = "+ Boolean.toString(noDuplicates(acNos)));


    }


    public static boolean noDuplicates(int[] arr) {

        for(int i=0; i<arr.length;i++) {
            for(int j=1; j<arr.length; j++) {
                if(arr[i] == arr[j])
                    return false; // duplicate!
            }
        }
        return true;
    }

}
