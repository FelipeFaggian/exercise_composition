package application;

import java.util.Locale;
import java.util.Scanner;

public class TestProgram {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		System.out.print("Enter salary: ");
		Double enterSalary = sc.nextDouble();

		sc.close();

	}

}
