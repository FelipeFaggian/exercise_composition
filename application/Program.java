package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<String> list = new ArrayList<String>();

		String[] lines = new String[] { "TV LED,1290.99,1", "Video Game Chair,350.50,3", "Iphone X,900.00,2",
				"Samsung Galaxy 9,850.00,2" };

		String path = "C:\\temp\\.csv";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		boolean file = new File("C:\\temp\\out").mkdir();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {
				String[] output = line.split(",");
				String name = output[0];
				int quantity = Integer.parseInt(output[2]);
				double price = Double.parseDouble(output[1]);
				double total = quantity * price;
				list.add(name + ", " + String.format("%.2f", total));
				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		String pathSum = "C:\\temp\\out\\summary.csv";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathSum))) {

			for (String sum : list) {
				bw.write(sum);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
}
