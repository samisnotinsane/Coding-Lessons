import java.util.ArrayList;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/* Date: 07/08/2016 Author: Sameen
 * Playing around with JavaFX Properties. Uses a football team metaphor.
 */

 class Person {
 	
 	// properties
 	private StringProperty nationality = new SimpleStringProperty();
 	private StringProperty firstName = new SimpleStringProperty();
 	private StringProperty surname = new SimpleStringProperty();
 	private IntegerProperty age = new SimpleIntegerProperty();
 	private StringProperty sex = new SimpleStringProperty();

 	// getters
 	private final String getNationality() {
 		return nationality.get();
 	}

 	private final String getFirstName() {
 		return firstName.get();
 	}

 	private final String getSurname() {
 		return surname.get();
 	}

 	private final int getAge() {
 		return age.get();
 	}

 	private final String getSex() {
 		return sex.get();
 	}

 	// setters
 	public final void setNationality(String value) {
 		nationality.set(value);
 	}

 	public final void setFirstName(String value) {
 		firstName.set(value);
 	}

 	public final void setSurname(String value) {
 		surname.set(value);
 	}

 	public final void setAge(int value) {
 		age.set(value);
 	}

 	public final void setSex(String value) {
 		sex.set(value);
 	}

 	// propertyGetters
 	public StringProperty nationalityProperty() {
 		return nationality;
 	}

 	public StringProperty firstNameProperty() {
 		return firstName;
 	}

 	public StringProperty surnameProperty() {
 		return surname;
 	}

 	public IntegerProperty ageProperty() {
 		return age;
 	}

 	public StringProperty sexProperty() {
 		return sex;
 	}

 	public static void main(String[] args) {
 		ArrayList<Person> team = new ArrayList<>();

 		Person striker = new Person();
 		Person midfielder = new Person();
 		Person defender = new Person();
 		Person goalkeeper = new Person();

 		striker.setNationality("Swedish");
 		striker.setFirstName("Zlatan");
 		striker.setSurname("Ibrahimović");
 		striker.setAge(34);
 		striker.setSex("Male");

 		midfielder.setNationality("English");
 		midfielder.setFirstName("Wayne");
 		midfielder.setSurname("Rooney");
 		midfielder.setAge(30);
 		midfielder.setSex("Male");
 		
 		defender.setNationality("Canadian");
 		defender.setFirstName("Lauren");
 		defender.setSurname("Sesselmann");
 		defender.setAge(32);
 		defender.setSex("Female");

		goalkeeper.setNationality("English");
 		goalkeeper.setFirstName("Joe");
 		goalkeeper.setSurname("Hart");
 		goalkeeper.setAge(29);
 		goalkeeper.setSex("Male");

 		team.add(striker);
 		team.add(midfielder);
 		team.add(defender);
 		team.add(goalkeeper);

 		// Print surname and age of team players
 		System.out.print("[ ");
 		for(Person player : team) {
 			System.out.print("[");
 			printNameAndAge(player);
 			System.out.print("]");
 			System.out.print(" ");
 		}
 		System.out.print("]\n");

 		// Calculate and print mean average age of team players
 		int[] playerAgeList = new int[team.size()];
 		for(int i=0; i<team.size(); i++) {
 			Person player = team.get(i);
 			playerAgeList[i] = player.getAge();
 		}
 		int meanAge = computeMean(playerAgeList);
 		System.out.print("Average player age: " + meanAge + "\n");

 	}

 	// prints in format: [surname, age]
 	public static void printNameAndAge(Person player) {
 		System.out.print(player.getSurname() + ", " + player.getAge());
 	}

 	public static int computeMean(int[] values) {
 		int sum = 0;
 		int noOfElement = values.length;
 		int mean = -1;
 		for(int value : values) {
 			sum += value;
 		}
 		mean = sum/noOfElement;
 		return mean;
 	}

 }