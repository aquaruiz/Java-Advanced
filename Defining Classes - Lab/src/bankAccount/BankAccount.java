package bankAccount;

public class BankAccount {
	private static int COUNTER = 0;
	private static double INTEREST_RATE = 0.02;
	
	private int id;
	private double balance;
	
	public BankAccount() {
		this.id = ++COUNTER;
	}
	
	public int getId() {
		return id;
	}
	
	public static void setInterestRate(double interest) {
		INTEREST_RATE = interest;
	}
	
	public double getInterest(int years) {
		return this.balance * years * INTEREST_RATE;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
}
