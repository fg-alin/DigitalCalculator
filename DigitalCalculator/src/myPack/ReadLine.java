package myPack;

public class ReadLine {

	Calculator calcu = new Calculator(0);

	public boolean validationFormatDouble(String sir) {

		int i = 0, g = 0;
		while (i < sir.length() && g == 0) {
			if ((sir.charAt(i) < '0' || sir.charAt(i) > '9') && sir.charAt(i) != '.') {
				g = 1;
			} else
				i++;
		}
		if (g == 1)
			throw new RuntimeException("NOK. Forbidden characters for \"double\" type!");

		else {
			int v = sir.indexOf('.');
			if (sir.indexOf('.', v + 1) >= 0)
				throw new RuntimeException("NOK. More than one dot in the number!");
		}
		if (sir.contains(".") && (sir.indexOf('.') == 0 || sir.indexOf('.') == sir.length() - 1))
			System.out.println("NOK. Dot at start or finish!");

		return true;

	}

	public double stringToDouble(String sirCorect) {

		double nr = 0;
		int j = 0, indexFinalIntreg;

		if (sirCorect.contains(".")) {
			indexFinalIntreg = sirCorect.indexOf('.') - 1;
		}

		else
			indexFinalIntreg = sirCorect.length() - 1;

		while (j <= indexFinalIntreg) {
			nr = nr * 10 + (sirCorect.charAt(j) - 48);
			j++;
		}

		for (int i = indexFinalIntreg + 2; i < sirCorect.length(); i++) {
			nr += (sirCorect.charAt(i) - 48) / (Math.pow(10, (i - indexFinalIntreg - 1)));
		}

		return nr;
	}

	public double verifyOperator(String sirCuOp) {

		if (this.validationFormatDouble(sirCuOp.substring(1))) {

			switch (sirCuOp.charAt(0)) {
			case '+':
				return calcu.addition(this.stringToDouble(sirCuOp.substring(1)));
			case '-':
				return calcu.subtraction(this.stringToDouble(sirCuOp.substring(1)));
			case '*':
				return calcu.multiplication(this.stringToDouble(sirCuOp.substring(1)));

			case '/':
				try {
					return calcu.division(this.stringToDouble(sirCuOp.substring(1)));
				} catch (ArithmeticException e) {
					e.printStackTrace();
				}

			case '=':
				return calcu.setting(this.stringToDouble(sirCuOp.substring(1)));
			case 'x':
				calcu.outProgram();

			default:
				System.out.println("Invalid operation");
			}
		} else
			System.out.println("NOK. Forbidden characters!");

		return calcu.getResult();

	}
}
