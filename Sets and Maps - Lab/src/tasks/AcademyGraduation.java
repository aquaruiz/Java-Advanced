package tasks;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = Integer.parseInt(scanner.nextLine());
		
		Map<String, List<Double>> school = new TreeMap<>();
		
		for (int i = 0; i < n; i++) {
			String studentName = scanner.nextLine();
			double[] grades = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
			double score = Arrays.stream(grades).average().orElse(0.0);
			school.put(studentName, new ArrayList<Double>());
			Arrays.stream(grades).forEach(grade -> school.get(studentName).add(grade));
		}
		
//		NumberFormat scoreFormat = new DecimalFormat("#.######################################################################################");
		
		for (String name : school.keySet()) {
			System.out.printf("%s is graduated with %s%n", name,
					getAverage(school.get(name)));
		}
	}
	
	private static Double getAverage(List<Double> grades){
        double total = 0d;
        for (int i = 0; i < grades.size(); i++) {
            total += grades.get(i);
        }
        return total / grades.size();
	}
}
