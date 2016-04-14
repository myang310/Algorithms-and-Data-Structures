package Sorts;

/*	Shell Sort
 *
 * For an array of size N, and using this h-sort increment of 1, 4, 13, 40, 121, ...,
 * All Cases: The number of compares is a small multiple of N times the number of 
 *		increments used
 * Worst Case: ~N^(3/2) compares
 */

public class Shell {
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N/3) 
			h = 3*h + 1;	// 1, 4, 13, 40, 121, 364, 1093, ...
		while (h >= 1)
		{	// h-sort the array
			for (int i = h; i < N; i++)
			{	// Insert a[i] among a[i-h], a[i-2*h], a[i-3*h], ...
				for (int j = i; j >= h && isLess(a[j], a[j-h]); j -= h)
					exchange(a, j, j-h);
			}
			h = h/3;
		}
	}

	
	private static boolean isLess(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exchange(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
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
