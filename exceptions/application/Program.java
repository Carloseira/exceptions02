package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = input.nextInt();
		System.out.print("Holder: ");
		input.nextLine();
		String holder = input.nextLine();
		System.out.print("Initial balance: ");
		double balance = input.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = input.nextDouble();
		
		Account acc = new Account(number, holder, balance, withdrawLimit);
		
		System.out.print("Enter amount for withdraw:");
		double amount = input.nextDouble();
		
		try {
			acc.withdraw(amount);
			System.out.printf("Update balance: %.2f%n", acc.getBalance());
		}
		catch (BusinessException e) {
			System.out.println("Warning: " + e.getMessage());
		}
		input.close();
	}
}
