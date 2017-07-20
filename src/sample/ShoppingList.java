package sample;

import java.util.ArrayList;
import java.util.List;

/**
 * @deprecated
 * Created by sameen on 10/07/2017.
 */
public class ShoppingList {

    private List<ShoppingItem> shoppingItemList;

    public ShoppingList() {
        this.shoppingItemList = new ArrayList<>();
    }

    public ShoppingList(List<ShoppingItem> shoppingList) {
        this.shoppingItemList = shoppingList;
    }

    public void addShoppingItem(ShoppingItem shoppingItem) {
        this.shoppingItemList.add(shoppingItem);
    }

    public List<ShoppingItem> getShoppingItemList() {
        return this.shoppingItemList;
    }

}
