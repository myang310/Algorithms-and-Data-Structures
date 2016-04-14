package Sorts;

/*	Insertion Sort
 *
 * For an array of size N,
 *	Average: ~N²/4 compares and ~N²/4 exchanges
 *	Worst Case: ~N²/2 compares and ~N²/2 exchanges
 *	Best Case: N-1 compares and 0 exchanges
 */

public class Insertion {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) 
		{	
			Comparable elementToSort = a[i];
			// while the current is less the previous, move the greater element right
			int j = i;
			while (j > 0 && isLess(a[j], a[j-1]))
				moveDown(a, j-1, j); 
			a[j] = elementToSort;
		}
	}
	
	public static void sort(Comparable[] a, int lo, int hi) 
	{	// used in Merge.sort for when the array size is less than or equal to 15
		for (int i = lo+1; i < hi; i++) 
		{	
			Comparable elementToSort = a[i];
			// while the current is less the previous, move the greater element right
			int j = i;
			while (j > lo && isLess(a[j], a[j-1]))
				moveDown(a, j-1, j); 
			a[j] = elementToSort;
		}
	}

	private static boolean isLess(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void moveDown(Comparable[] a, int i, int j) {
		a[j] = a[i];
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (isLess(a[i], a[i-1]))
				return false;
		
		return true;
	}
}
