public class Selection {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;  // index of current minimum value
			for (int j = i+1; j < N; j++)
				if (isLessThan(a[j], a[min]))
					min = j;   // replace with index of new minimum value
			exchange(a, i, min);
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
