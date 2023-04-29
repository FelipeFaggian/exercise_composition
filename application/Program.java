package application;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import entities.StudentCode;

public class Program {
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Set<StudentCode> set = new HashSet<>();

		System.out.print("How many students for course A? ");
		int n = sc.nextInt();
		
		for (int i = 0; i<n; i++) {	
		int number = sc.nextInt();
		set.add(new StudentCode(number));
		}
		
		System.out.print("How many students for course B? ");
		n = sc.nextInt();
		
		for (int i = 0; i<n; i++) {	
		int number = sc.nextInt();	
		set.add(new StudentCode(number));
		}
		
		System.out.print("How many students for course C? ");
		n = sc.nextInt();
		
		for (int i = 0; i<n; i++) {		
		int number = sc.nextInt();	
		set.add(new StudentCode(number));
		}
	
		System.out.print("Total students: " + set.size());
		
		sc.close();
	}
}
