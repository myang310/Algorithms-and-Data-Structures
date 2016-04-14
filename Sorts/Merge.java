package Sorts;

/* (Top-down) Merge Sort
 *
 * For an array of size N
 * Worst Case: ~NlgN compares and 6NlgN array accesses (2N for copying,
 *				   2N for moving back and 2N for compares)
 * Best Case: ~1/2NlgN compares
 */

public class Merge 
{
	private static Comparable[] aux;  // auxiliary array for merges

	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];  // allocate space just once
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi)
	{
		int N = hi - lo + 1;	
		if (N > 15) 
		{	// sort a[lo..hi] via merge sort for arrays larger than size 15
			if (hi <= lo) return;
			int mid = lo + (hi - lo)/2;
			sort(a, lo, mid);			// sort left half
			sort(a, mid+1, hi);		// sort right half
			merge(a, lo, mid, hi);	// merge results
		} 
		else
		{	// sort a[lo..hi] via insertion sort for arrays smaller or equal to size 15
			Insertion.sort(a, lo, hi);
		}
	}

	private static void merge(Comparable[] a, int lo, int mid, int hi)
	{	// merge a[lo..mid] with a[mid+1..hi]
		int i = lo;

		for (int k = lo; k <= hi; k++)  // copy a[lo..hi] to aux[lo..hi]
			aux[k] = a[k];

		for (int k = lo; k <= hi; k++) 
		{	// merge back to a[lo..hi]
			if (i > mid)							a[k] = aux[j++];
			else if (j > hi)						a[k] = aux[i++];
			else if (isLess(aux[j], aux[i]))	a[k] = aux[j++];
			else										a[k] = aux[i++];
		}
	}
}
