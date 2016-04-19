public class MergeSort
{
	public static void main(String[] args)
	{
		int[] a = {3,8,2,4,7,1,9};

		System.out.print("'a' unsorted: ");
		for(int i=0; i<a.length; i++) 
		{
			System.out.print(a[i]);
		}
		System.out.print("\n");
		
		System.out.println("Sorting a...\n");
		sort(a); // Perform merge sort destructively on a[]

		System.out.print("'a' sorted: ");
		for(int i=0; i<a.length; i++)
		{
			System.out.print(a[i]);
		}
		System.exit(0);
	}

	public static void sort(int[] a)
	{
		int longLength = a.length;

		if(longLength < 2)
			return; // base case

		int midPoint = (longLength/2) ;

		// create and populate left & right sublists
		int[] left = new int[midPoint] ;
		int[] right = new int[longLength - midPoint] ;

		for(int i=0; i<midPoint-1; i++)
			left[i] = a[i] ;
		for(int i=midPoint; i<longLength-1; i++)
			right[i-midPoint] = a[i] ;

		// sort both sublists recursively
		sort(left) ;
		sort(right) ;

		
	}
}