package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enumsJava.OrderStatus;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Order orders = new Order();
		OrderItem orderItem = new OrderItem();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String productName;
		Double price, sum = 0.0;
		Integer quantity;

		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		System.out.println("Enter order data: ");
		Client client = new Client(name, email, birthDate);

		System.out.print("Status: ");
		String enumStatus = sc.next();
		OrderStatus os2 = OrderStatus.valueOf(enumStatus);

		System.out.print("How many items to this order? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data: ");
			sc.nextLine();
			System.out.print("Product name: ");
			productName = sc.nextLine();
			System.out.print("Product price: ");
			price = sc.nextDouble();
			System.out.print("Quantity: ");
			quantity = sc.nextInt();
			orderItem = new OrderItem(quantity, price, new Product(productName, price));
			orders.addItem(orderItem);
			sum += orderItem.subTotal();
		}

		List<OrderItem> y = orders.getOrder();

		System.out.println();

		System.out.println("ORDER SUMMARY: ");
		Calendar calendar = Calendar.getInstance();
		Date data = calendar.getTime();
		orders = new Order(data, os2, client);
		SimpleDateFormat sdDiaHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String moment = sdDiaHora.format(data);
		String birth = sdf.format(client.getBirthDate());

		System.out.println("Order moment: " + moment);	
		System.out.println("Order status: " + os2);
		System.out.println("Client: " + client.getName() + " (" + birth + ") - " + client.getEmail());
		System.out.println("Order items: ");    
		
		for (OrderItem x : y) {

			System.out.println(x);
		}

		System.out.printf("Total price: $%.2f", sum);

		sc.close();
	}
}
