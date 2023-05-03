package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Program {
	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		final Map<String, Integer> mapUrney = new TreeMap<>();

		System.out.print("Enter file full path: ");
		String pathFile = sc.nextLine();
		File sourceFile = new File(pathFile);

		try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
			String line = br.readLine();
			while (line != null) {
				String[] field = line.split(",");
				String name = field[0];
				Integer votes = Integer.parseInt(field[1]);
				if (mapUrney.containsKey(name) == true) {
					votes = votes + mapUrney.get(name);
					mapUrney.put(name, votes);
				} else {
					mapUrney.put(name, votes);
				}
				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println(e);
		}

		final Map<String, Integer> mapUrneyOrder = mapUrney.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(
						Map.Entry::getKey, 
						Map.Entry::getValue, 
						(e1, e2) -> e1, LinkedHashMap::new));
		
		mapUrneyOrder.forEach(((key, value) -> System.out.println(key + ": " + mapUrney.get(key))));

		sc.close();
	}
}
