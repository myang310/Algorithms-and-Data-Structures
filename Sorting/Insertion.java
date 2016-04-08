public class Insertion {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			// while the current is less the previous, keep swapping
			for (int j = i; j > 0 && isLessThan(a[j], a[j-1]; j--)
				exchange(a, j, j-1); 
		}
	}
	
	private static boolean isLessThan(Comparable v, Comparable w) {
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
			if (isless(a[i], a[i-1]))
				return false;
		
		return true;
	}
}
