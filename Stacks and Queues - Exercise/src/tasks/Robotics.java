package tasks;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Robotics {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		String[] roboData = scanner.nextLine().split(";");
		
		String[] robots = new String[roboData.length];
		int[] workingTime = new int[roboData.length];
		int[] processingTime = new int[roboData.length];
		
		for (int i = 0; i < roboData.length; i++) {
			robots[i] = roboData[i].split("-")[0];
			workingTime[i] = Integer.parseInt(roboData[i].split("-")[1]);
		}
		
		String[] timeData = scanner.nextLine().split(":");
		int hours = Integer.parseInt((timeData[0]));
		int minutes = Integer.parseInt((timeData[1]));
		int seconds = Integer.parseInt((timeData[2]));

		int startTime = hours * 3600 + minutes * 60 + seconds;
		
		int time = 0;
		
		Deque<String> products = new ArrayDeque<>();
		String currentProduct = scanner.nextLine();

		while(!currentProduct.equals("End")) {
			products.offer(currentProduct);
			currentProduct = scanner.nextLine();
		}
		
		while (!products.isEmpty()){
			time++;
			String product = products.pollFirst();
			boolean isAssigned = false;
			
			for (int i = 0; i < robots.length; i++) {
				if (processingTime[i] == 0 && !isAssigned) {
					processingTime[i] = workingTime[i];
					printTaks(robots[i], startTime + time, product);
					isAssigned = true;
				}
				
				if(processingTime[i] > 0) {
					processingTime[i]--;
				}
			}
			
			if (!isAssigned) {
				products.offer(product);
			}
		}
	}

	private static void printTaks(String robot, int time, String product) {
		int hours = (time / 3600) % 24;
		int minutes = time % 3600 / 60;
		int seconds = time % 60;
		
		DecimalFormat format = new DecimalFormat("00");
		System.out.println(String.format("%s - %s [%s:%s:%s]", 
				robot, product, format.format(hours), format.format(minutes), format.format(seconds)));
	}
}