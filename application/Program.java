package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Individuals;
import entities.LegalPerson;
import entities.Register;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Register> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			Double income = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				list.add(new Individuals(name, income, healthExpenditures));
			}
			if (ch == 'c') {
				System.out.print("Number of employees: ");
				Integer numberOfEmployees = sc.nextInt();
				list.add(new LegalPerson(name, income, numberOfEmployees));
			}
		}

		System.out.println();
		System.out.println("TAXES PAID: ");
		
		for (Register register : list) {
			System.out.println(register);
		}

		Double sum = 0.0;

		for (Register register : list) {
			sum += register.tax();
		}

		System.out.println();
		System.out.printf("TOTAL TAXES: $ %.2f", sum);

		sc.close();
	}
}
