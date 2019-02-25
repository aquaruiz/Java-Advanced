package tasks;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVat {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double[] prices = Arrays.stream(scanner.nextLine().split(", ")).mapToDouble(Double::parseDouble).toArray();

		UnaryOperator<Double> addVat = (x) -> 1.2 * x;

		System.out.println("Prices with VAT:");

		for (double price : prices) {
			DecimalFormat priceFormat = new DecimalFormat("0.00");
			double newPrice = addVat.apply(price);
			System.out.println(priceFormat.format(newPrice));
		}
	}

}
