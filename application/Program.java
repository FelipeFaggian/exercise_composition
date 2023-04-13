package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		ImportedProduct imp = new ImportedProduct();
		UsedProduct used = new UsedProduct();
		Product prod = new Product();

		List<Product> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		char ch = 0;

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();

			if (ch == 'i') {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				imp = new ImportedProduct(name, price, customsFee);
				list.add(imp);
			}

			else if (ch == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				used = new UsedProduct(name, price, manufactureDate);
				list.add(used);
			}

			else {
				prod = new Product(name, price);
				list.add(prod);
			}
		}

		System.out.println();

		System.out.println("PRICE TAGS: ");

			for (int i = 0; i < n; i++) {
				System.out.println(list.get(i));
			}
		

		sc.close();
	}
}
