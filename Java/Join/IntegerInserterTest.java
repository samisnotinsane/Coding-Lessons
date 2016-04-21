import java.util.*;

public class IntegerInserterTest 
{
	public static void main(String[] args) 
	{
		Integer[] aTestDigits = {3,5,12,24,35};
		ArrayList<Integer> testDigits = new ArrayList<>();
		System.out.println("Populating array...");
		testDigits.addAll(Arrays.asList(aTestDigits));
		printList(testDigits);

		IntegerInserter intIns = new IntegerInserter(); 
		System.out.println("Calling join");
		ArrayList changedTestDigits = intIns.join(13, testDigits);
		printList(changedTestDigits);


	}

	public static <T> void printList(Collection<T> ls)
	{
		Iterator<T> it = ls.iterator();
		System.out.print("[ ");
		while(it.hasNext()) 
		{
			T element = it.next();
			System.out.print(element + " ");
		}
		System.out.print("]\n");
	}
}