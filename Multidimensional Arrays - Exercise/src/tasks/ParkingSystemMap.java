package tasks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ParkingSystemMap {

	public static void main(String[] args) {
		// Solution without matrices => 100/100 in Judge

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        Map<Integer, Set<Integer>> parking = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("stop"))
        {
            String[] parameters = input.split(" ");

            int entryRow = Integer.parseInt(parameters[0]);
            int desiredRow = Integer.parseInt(parameters[1]);
            int desiredCol = Integer.parseInt(parameters[2]);

            // Where is parked?
            int parkColumn = 0;

            if (!IsOccupied(parking, desiredRow, desiredCol))
            {
                parkColumn = desiredCol;
            }
            else
            {
                for (int i = 1; i < cols - 1; i++)
                {
                    if (((desiredCol - i) > 0) &&
                        !IsOccupied(parking, desiredRow, (desiredCol - i)))
                    {
                        parkColumn = (desiredCol - i);
                        break;
                    }
                    else if (((desiredCol + i) < cols) &&
                             !IsOccupied(parking, desiredRow, (desiredCol + i)))
                    {
                        parkColumn = (desiredCol + i);
                        break;
                    }
                }
            }

            if (parkColumn == 0)
            {
                System.out.printf("Row %d full%n", desiredRow);
            }
            else
            {
                parking.get(desiredRow).add(parkColumn);
                int steps = Math.abs(entryRow - desiredRow) + 1 + parkColumn;
                System.out.println(steps);
            }

            input = scanner.nextLine();
        }
    }

    private static boolean IsOccupied(Map<Integer, Set<Integer>> parking, int row, int col)
    {
        if (parking.containsKey(row))
        {
            if (parking.get(row).contains(col))
            {
                return true;
            }
        }
        else
        {
        	parking.put(row, new HashSet<Integer>());
        }
        return false;
    }
}