import javafx.beans.property.SimpleStringProperty;

/**
 * Created by sameenislam on 16/03/2016.
 */
public class ComputerType {

    private final SimpleStringProperty typeName = new SimpleStringProperty("");

    public ComputerType() {
        this("");
    }

    public ComputerType(String typeName) {
        setTypeName(typeName);
    }

    public void setTypeName(String tName) {
        typeName.set(tName);
    }

    public String getTypeName() {
        return typeName.get();
    }
}
