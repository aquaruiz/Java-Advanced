package tasks;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TheHeiganDance {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		final int rows = 15;
		final int cols = 15;
		
		boolean[][] chamber = new boolean[rows][cols];
		
		int playerX = rows / 2;
		int playerY = cols / 2;
		
		double playerHitPoints = 18500;
		double heiganHitPoints = 3000000;
		String causeOfDead = null;
		
		boolean isPlagueActive = false;
		Double heiganDamage = Double.parseDouble(scanner.nextLine());
		
		while(playerHitPoints > 0 && heiganHitPoints > 0) {
			String[] input = scanner.nextLine().split(" ");
			chamber = new boolean[rows][cols];
			
			heiganHitPoints -= heiganDamage;
			
			if (heiganHitPoints <= 0) {
				if (isPlagueActive) {
					playerHitPoints -= 3500;
					isPlagueActive = false;
					
					if (playerHitPoints <= 0) {
						break;
					}
				}
				
				break;
			}
			
			if (isPlagueActive) {
				playerHitPoints -= 3500;
				isPlagueActive = false;
				
				if (playerHitPoints <= 0) {
					break;
				}
			}
			
			String spellName = input[0];
			causeOfDead = spellName;
			int spellX = Integer.parseInt(input[1]);
			int spellY = Integer.parseInt(input[2]);
			
			// locate damages
			int damageStartRow = Math.max(spellX - 1, 0);
			int damageEndRow = Math.min(spellX + 1, rows - 1);
			int damageStartCol = Math.max(spellY - 1, 0);
			int damageEndCol = Math.min(spellY + 1, cols - 1);
			
			chamber = new boolean[rows][cols];
			
			for (int i = damageStartRow; i <= damageEndRow; i++) {
				for (int j = damageStartCol; j <= damageEndCol; j++) {
					chamber[i][j] = true;
				}
			}
			
			// check player position
			// directions order: up - right - down - left
			if (playerX >= damageStartRow 
					&& playerX <= damageEndRow
					&& playerY >= damageStartCol
					&& playerY <= damageEndCol) {
				
				if (playerX - 1 >= 0 && !chamber[playerX - 1][playerY]) {
					playerX--;
				} else if(playerY + 1 < cols && !chamber[playerX][playerY + 1]) {
					playerY++;
				} else if (playerX + 1 < rows && !chamber[playerX + 1][playerY]) {
					playerX++;
				} else if (playerY - 1 >= 0 && !chamber[playerX][playerY - 1]) {
					playerY--;
				} else {
					switch (spellName) {
					case "Cloud":
						playerHitPoints -= 3500;
						isPlagueActive = true;
						break;
					case "Eruption":
						playerHitPoints -= 6000;
						break;
					default:
						break;
					}
				}
			}
		}
		
		if (heiganHitPoints <= 0) {
			System.out.println("Heigan: Defeated!");
		} else {
			DecimalFormat df = new DecimalFormat("#.00");
			System.out.println("Heigan: " + df.format(heiganHitPoints));
		}
		
		if (playerHitPoints <= 0) {
			System.out.printf("Player: Killed by %s%n",
					causeOfDead.equals("Cloud") ? "Plague Cloud" : causeOfDead);
		} else {
			System.out.println("Player: " + (int)playerHitPoints);
		}
		
		System.out.printf("Final position: %d, %d", 
				playerX,
				playerY);
	}
}