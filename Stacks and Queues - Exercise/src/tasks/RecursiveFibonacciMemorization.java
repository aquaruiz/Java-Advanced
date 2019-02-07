package tasks;

import java.util.Scanner;

public class RecursiveFibonacciMemorization {

	static long[] memory;
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		memory = new long[n + 1];
		
		long fibo = calcFibo(n);
		System.out.println(fibo);
	}

	private static long calcFibo(int n) {
		if (n < 2) {
			return 1;
		}
		
		if (memory[n] != 0) {
			return memory[n];
		}
		
		return memory[n] = calcFibo(n - 1) + calcFibo(n - 2);
	}

}
