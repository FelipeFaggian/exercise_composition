package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employees;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(new Locale("en", "US"));
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter full file path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Employees> list = new ArrayList<>();

			String line = br.readLine();

			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Employees(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}

			System.out.print("Enter salary: ");
			Double salary = sc.nextDouble();

			List<String> emails = list.stream().filter(p -> p.getSalary() > salary).map(p -> p.getEmail()).sorted()
					.collect(Collectors.toList());

			System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary) + ":");

			emails.forEach(System.out::println);

			Double sum = list.stream().filter(p -> p.getName().charAt(0) == 'M').map(p -> p.getSalary()).reduce(0.0,
					(x, y) -> x + y);

			System.out.printf("Sum of salary of people whose name starts with 'M': %.2f", sum);

		} catch (IOException e) {
			System.out.println("Error: " + e);
		}

		sc.close();
	}
}
