import java.util.*;

public class FindTheBiggest {
	public static void main(String[] args) {

		Camp malibu = new Camp("Malibu", 36);
		Camp tipper = new Camp("Tipper", 12);
		Camp catsEye = new Camp("CatsEye", 122);
		Camp everest = new Camp("Everest", 1024);

		Camp[] campCollection = {
			malibu, everest, tipper, catsEye
		};

		System.out.println("Finding biggest camp...");
		Camp biggest = greatest(campCollection,
									 new CampComparator());
		System.out.println("Largest camp is: "+
										biggest.toString());

		List<Camp> campList = new ArrayList<Camp>();
		for(int i=0; i<campCollection.length; i++)
		{
			campList.add(campCollection[i]);
		}

		Camp triSector = new Camp("TriSector", 40);

		
		if(atLeastCollection(campList, triSector, 1)) 
			System.out.println("Camps are available that are larger than TriSector");
		else
			System.out.println("Sorry, there are no camps larger than TriSector at the moment!");

		System.exit(0);
	}

	public static <E> E greatest(E[] ls, Comparator<E> comp) 
	{
		E biggestSoFar = ls[0];
		for(int i=1; i<ls.length; i++) {
			if(comp.compare(biggestSoFar, ls[i]) > 0)
				biggestSoFar = ls[i];
		}
		return biggestSoFar;	
	}

	public static <E extends Comparable<? super E>> boolean atLeast(
										ArrayList<E> ls, E obj, int n)
	{
		int count = 0;
		for(int i=0; i<ls.size(); i++)
		{
			E element = ls.get(i);
			if((obj.compareTo(element) > 0))
				count++;
		}
		if(count >= n)
			return true;
		else 
			return false;
	}

	/********************************************************
	 * Can handle ANY Collection type, not just an ArrayList*
	 ********************************************************/
	public static <E extends Comparable<? super E>> boolean 
					atLeastCollection(Collection<E> ls, E obj, int n)
	{
		int count = 0;
		
		Iterator<E> it = ls.iterator();
		try {
			while(it.hasNext()) {
				E element = it.next();
				if((obj.compareTo(element) > 0))
					count++;
			}
		} catch (NoSuchElementException e) {System.exit(-1);}
		
		if(count >= n)
			return true;
		else 
			return false;
		
	}
}