import org.junit.*;
import static org.junit.Assert.*;

public class RPNCalculatorTest {
	// Test simple addition
	@Test
	public void testSimpleAddition() {
		RPNCalculator calculator = new RPNCalculator();
		int result = calculator.evaluate("7 11 +");
		assertEquals(18, result);
	}

	// Test simple subtraction
	@Test
	public void testSimpleSubtraction() {
		RPNCalculator calculator = new RPNCalculator();
		int result = calculator.evaluate("13 3 -");
		assertEquals(10, result);
	}

	// Test simple multiplication
	@Test
	public void testSimpleMultiplication() {
		RPNCalculator calculator = new RPNCalculator();
		int result = calculator.evaluate("5 8 *");
		assertEquals(40, result);
	}

	// Test a complex expression
	@Test
	public void testComplexExpression() {
		RPNCalculator calculator = new RPNCalculator();
		int result = calculator.evaluate("6 2 3 + 5 * + 7 -");
		assertEquals(24, result);
	}
}