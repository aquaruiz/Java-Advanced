package tasks;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AverageStudentsGrades {
// judge 90/100
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = Integer.parseInt(scanner.nextLine());
		Map<String, List<Double>> studentsGrades = new TreeMap<>();
		
		for (int i = 0; i < n; i++) {
			String[] inputs = scanner.nextLine().split(" ");
			String studentName = inputs[0];
			double grade = Double.parseDouble(inputs[1]);
			if (!studentsGrades.containsKey(studentName)) {
				studentsGrades.put(studentName, new LinkedList<Double>());
			}
			
			studentsGrades.get(studentName).add(grade);
		}
		
		for (String name: studentsGrades.keySet()) {
			System.out.print(name + " -> ");
			LinkedList<Double> grades = (LinkedList<Double>) studentsGrades.get(name);
			
			for (Double grade : grades) {
				System.out.printf("%.2f ", grade);
			}
			
			double average = getAverage(grades);
			System.out.printf("(avg: %.2f)%n", average);
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