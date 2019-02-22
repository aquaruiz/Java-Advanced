package tasks;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Map<String, Double>> shop = new TreeMap<>();
		String line = scanner.nextLine();
				
		while(!line.equals("Revision")) {
			String[] input = line.split(", ");
			String shopName = input[0];
			String productName = input[1];
			Double productPrice = Double.parseDouble(input[2]);
			
			if (!shop.containsKey(shopName)) {
				shop.put(shopName,  new LinkedHashMap<String, Double>());
			}
			
			shop.get(shopName).put(productName, productPrice);
			
			line = scanner.nextLine();
		}
		
		for (String shopName: shop.keySet()) {
			System.out.println(shopName + "->");
			
			for (String product : shop.get(shopName).keySet()) {
				System.out.printf("Product: %s, Price: %.1f%n", product, shop.get(shopName).get(product));
			}
		}
	}
}