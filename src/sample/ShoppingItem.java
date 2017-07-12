package sample;

/**
 * Created by sameen on 10/07/2017.
 */
public class ShoppingItem {

    private String name;

    public ShoppingItem() {

    }

    public ShoppingItem(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
