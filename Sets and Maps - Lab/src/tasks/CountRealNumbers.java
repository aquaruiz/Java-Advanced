package tasks;

import java.awt.RenderingHints.Key;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import javax.security.auth.kerberos.KerberosKey;

public class CountRealNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		double[] input = Arrays.stream(scanner.nextLine().split(" "))
				.mapToDouble(Double::parseDouble)
				.toArray();
		Map<Double, Integer> counts = new LinkedHashMap<>();
		
		for (int i = 0; i < input.length; i++) {
			if (!counts.containsKey(input[i])) {
				counts.put(input[i], 0);
			}
			
			counts.put(input[i], counts.get(input[i]) + 1);
		}
		
		for (Double k : counts.keySet() ) {
			System.out.printf("%.1f -> %s%n", k, counts.get(k));
		}
	}
}
