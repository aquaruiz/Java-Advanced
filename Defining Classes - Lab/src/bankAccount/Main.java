package bankAccount;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<BankAccount> myBankAccounts = new LinkedList<>();
		
		BankAccount myBankAccount;
		
		String lineString = scanner.nextLine();
		
		while(!lineString.equals("End")) {
			String[] tokens = lineString.split(" ");
			String command = tokens[0];
			
			switch (command) {
			case "Create":
				myBankAccount = new BankAccount();
				int id = myBankAccount.getId();
				System.out.println(String.format("Account ID%d created", id));
				myBankAccounts.add(myBankAccount);
				break;
			case "Deposit":
				int idDeposit = Integer.parseInt(tokens[1]);
				double depositAmount = Double.parseDouble(tokens[2]);
				try {
					myBankAccounts.get(idDeposit - 1).deposit(depositAmount);
					System.out.println(String.format("Deposited %.0f to ID%d", 
							depositAmount,
							idDeposit));
				} catch (Exception e) {
					System.out.println("Account does not exist");
				}
				break;
			case "SetInterest":
				double newInterest = Double.parseDouble(tokens[1]);
				BankAccount.setInterestRate(newInterest);
				break;
			case "GetInterest":
				idDeposit = Integer.parseInt(tokens[1]);
				int years = Integer.parseInt(tokens[2]);
				try {
					double gettedInterest = myBankAccounts.get(idDeposit - 1).getInterest(years);
					System.out.println(String.format("%.2f", gettedInterest));
				} catch (Exception e) {
					System.out.println("Account does not exist");
				}
				break;
			default:
				break;
			}
			
			lineString = scanner.nextLine();
		}
		
		scanner.close();
	}

}