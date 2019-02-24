package task1OtherTry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class Program2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int capacity = Integer.parseInt(reader.readLine());

		String[] tokens = reader.readLine().split("\\s+");

		Deque<Character> halls = new ArrayDeque<>();
		LinkedHashMap<Character, Deque<Integer>> reservations = new LinkedHashMap<>();
		LinkedHashMap<Character, Integer> freeCapacity = new LinkedHashMap<>();

		for (int i = tokens.length - 1; i >= 0; i--) {
			if (Character.isAlphabetic(tokens[i].charAt(0))) {
				halls.offer(tokens[i].charAt(0));
				reservations.put(tokens[i].charAt(0), new ArrayDeque<>());
				freeCapacity.put(tokens[i].charAt(0), capacity);
			} else {
				if (halls.size() > 0) {
					char hall = halls.peek();
					int reservation = Integer.parseInt(tokens[i]);
					if (freeCapacity.get(hall) >= reservation) {
						freeCapacity.put(hall, freeCapacity.get(hall) - reservation);
						reservations.get(hall).offer(reservation);
//                        if (freeCapacity.get(hall) == 0) {
//                            halls.poll();
//                            System.out.println(String.format("%c -> %s", hall,
//                                    reservations.get(hall).stream().map(String::valueOf).collect(Collectors.joining(", "))));
//                            freeCapacity.remove(hall);
//                            reservations.remove(hall);
//                        }
					} else {
						char overflowed = halls.poll();
						System.out.println(String.format("%c -> %s", overflowed, reservations.get(overflowed).stream()
								.map(String::valueOf).collect(Collectors.joining(", "))));
						freeCapacity.remove(overflowed);
						reservations.remove(overflowed);
						if (halls.size() > 0) {
							hall = halls.peek();
							freeCapacity.put(hall, freeCapacity.get(hall) - reservation);
							reservations.get(hall).offer(reservation);
						}
					}
				}
			}
		}
	}
}
