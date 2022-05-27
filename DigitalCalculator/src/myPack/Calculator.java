package myPack;

public class Calculator {

	private static double result;

	public Calculator(double valComanda) {
		result = valComanda;
	}

	public double getResult() {
		return result;
	}

	public double addition(double val) {
		result += val;
		return result;
	}

	public double subtraction(double val) {
		result -= val;
		return result;
	}

	public double multiplication(double val) {
		result *= val;
		return result;
	}

	public double division(double val) throws ArithmeticException {
		if (val == 0) {
			throw new ArithmeticException("Division by zero is not allowed! The result was reset to zero. You can retry.");
		}
		result /= val;
		return result;
	}

	public double setting(double val) {
		result = val;
		return result;
	}

	public void outProgram() {
		System.exit(0);
	}

}
