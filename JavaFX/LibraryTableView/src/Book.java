import javafx.beans.property.SimpleStringProperty;

/**
 * Created by sameenislam on 14/03/2016.
 * Source: https://examples.javacodegeeks.com/desktop-java/javafx/tableview/javafx-tableview-example/
 */
public class Book {
    private SimpleStringProperty title;
    private SimpleStringProperty author;

    public Book() {

    }

    public Book (String s1, String s2) {

        title = new SimpleStringProperty(s1);
        author = new SimpleStringProperty(s2);
    }

    public String getTitle() {

        return title.get();
    }
    public void setTitle(String s) {

        title.set(s);
    }

    public String getAuthor() {

        return author.get();
    }
    public void setAuthor(String s) {

        author.set(s);
    }

    @Override
    public String toString() {

        return (title.get() + ", by " + author.get());
    }
}
