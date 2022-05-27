//# This program simulates a digital calculator. It works with the 4 main operations (+, -, *, /).

package myPack;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ArithmeticException {

		ReadLine cit1 = new ReadLine();
		if (args.length == 1) {
			String s = args[0];
			cit1.calcu.setting(cit1.verifyOperator("+" + s));
		}

		System.out.print(cit1.calcu.getResult() + "\n>");

		Scanner scanu = new Scanner(System.in);
		String linie;

		do {
			linie = scanu.nextLine();
			System.out.print(cit1.verifyOperator(linie) + "\n> ");
		} while (linie.charAt(0) != 'x');

		scanu.close();

	}
}
