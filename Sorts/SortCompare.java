package Sorts;

import java.lang.Math;
import java.io.PrintStream;

public class SortCompare {
	private static class Stopwatch {
		long startTime;

		public Stopwatch() {
			startTime = System.currentTimeMillis();
		}

		public double elapsedTime() {
			return (double) (System.currentTimeMillis() - startTime);
		}
	}
	
	public static double time(String alg, Double[] a) {
		Stopwatch timer = new Stopwatch();
		switch(alg) {
			case "Insertion":	Insertion.sort(a);
									break;
			case "Selection": Selection.sort(a);
									break;
			case "Shell":		Shell.sort(a);
									break;
			case "Merge":		Merge.sort(a);
									break;
			case "Quick":		Quick.sort(a);
									break;
			case "Heap":		Heap.sort(a);
									break;
		}
		return timer.elapsedTime();
	}

	public static double timeRandomInput(String alg, int N, int T)
	{	// Use alg to sort T random arrays of length N.
		double total = 0.0;
		Double[] a = new Double[N];
		for (int t = 0; t < T; t++)
		{	// Perform one experiment (generate and sort an array).
			for (int i = 0; i < N; i++)
				a[i] = Math.random();
			total += time(alg, a);
		}
		return total;
	}

	public static void main(String[] args)
	{
		String alg1 = args[0];
		String alg2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);
		double t1 = timeRandomInput(alg1, N, T);
		double t2 = timeRandomInput(alg2, N, T);
		System.out.printf("For %d random Doubles:\n\t%s is", N, alg1);
		System.out.printf(" %.2f times faster than %s", t2/t1, alg2);
	}
}
