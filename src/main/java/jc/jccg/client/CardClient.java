package jc.jccg.client;

import java.util.Scanner;

public class CardClient {
	
	public static void print(String line) {
		System.out.print(line);
	}
	public static void println(String line) {
		System.out.println(line);
	}
	public static void println(char line) {
		System.out.println(line);
	}
	public static void println() {
		System.out.println();
	}
	
	private static String getInput() {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		in.close();
		return s;
	}

	
	public static void mainMenu() {
		println("-------------------- JCCG Console Mode Main Menu --------------------");
		println();
		println("1: New Game as JC");
		println("x: Quit");
		println();
		println("---------------------------------------------------------------------");
		print(">");
		
		String in = getInput().toLowerCase();
		
		boolean validInput = false;
		while (!validInput) {
			if ("1".equals(in)) {
				validInput = true;
				newGame();
			}
			else if ("x".equals(in)) {
				validInput = true;
				System.exit(0);
			}
		}
	}
	
	public static void newGame() {
		print("Your Game Key: ");
		println();
		print("Your Player Key: ");
		println();
		displayHand();
		println("---------------------------------------------------------------------");
		println();
		println();
		println("---------------------------------------------------------------------");
		print(">");
	}
	
	public static void displayHand() {
		
	}
	
	public static void main(String[] args) {
		mainMenu();
	}
}
