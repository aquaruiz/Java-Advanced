package socks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		ArrayDeque<Integer> mySocksStack = new ArrayDeque<>();
		ArrayDeque<Integer> mySocksQueue = new ArrayDeque<>();
		ArrayList<Integer> pairs = new ArrayList<>();
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int[] input = Arrays.stream(scanner.nextLine().split(" "))
		.mapToInt(Integer::parseInt)
		.toArray();
		
		for (int i = 0; i < input.length; i++) {
			mySocksStack.push(input[i]);
		}

		int[] input2 = Arrays.stream(scanner.nextLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		
		for (int i = 0; i < input2.length; i++) {
			mySocksQueue.offer(input2[i]);
		}
		
		while (!mySocksStack.isEmpty() && !mySocksQueue.isEmpty()){
			int leftSock = mySocksStack.pop();
			int rightSock = mySocksQueue.peek();
			
			if (rightSock > leftSock) {
			} else if (leftSock > rightSock) {
				rightSock = mySocksQueue.removeFirst();
				pairs.add(leftSock + rightSock);
			} else {
				rightSock = mySocksQueue.removeFirst();
				leftSock++;
				mySocksStack.push(leftSock);
			}
		}
		
		List<Integer> sortedList = new ArrayList<>(pairs);
		sortedList.sort((a, b) -> b.compareTo(a));
		System.out.println(sortedList.get(0));
		
		for (int i : pairs) {
			System.out.print(i + " ");
		}
	}
}
