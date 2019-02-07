package tasks;

import java.util.Scanner;

public class RecursiveFibonacci {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		int fibo = calcFibo(n);
		System.out.println(fibo);
	}

	private static int calcFibo(int n) {
		if (n < 2) {
			return 1;
		}
		
		return calcFibo(n - 1) + calcFibo(n - 2);
	}
}
