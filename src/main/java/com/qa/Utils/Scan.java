package com.qa.Utils;

import java.util.Scanner;

public class Scan {
	
	static Scanner sc = new Scanner(System.in);
	
	static String input() {
		return sc.nextLine();
	}
	
	static int inputInt() {
		int input;
		input = sc.nextInt();
		sc.nextLine();
		return input;
	}
}
