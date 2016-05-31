/**
 * Created by sameenislam on 02/05/2016.
 */
public class Account {
    private int number; // A/C number

    public Account(int num) {
        number = num;
    }

    public String toString() {
        return "A/C no. = " + Integer.toString(number);
    }
}
