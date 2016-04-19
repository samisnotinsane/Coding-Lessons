import java.util.*;

public class CampComparator implements Comparator
{
	@Override
	public int compare(Object c1, Object c2) {
		int c1Size = ((Camp)c1).getSize();
		int c2Size = ((Camp)c2).getSize(); 

		return c2Size - c1Size;
	}
}