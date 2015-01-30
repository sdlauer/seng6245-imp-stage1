package edu.ecu.cs.sle.imp.interpreter;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.ecu.cs.sle.imp.value.IntegerValue;
import edu.ecu.cs.sle.imp.ast.UnaryMinusExpression;

public class InterpreterTest {

	private static Interpreter interpreter;
	
	@BeforeClass
	public static void setUpClass() {
		interpreter = new Interpreter();
	}
	
	@Test
	public void testMultiply1by2() {
		IntegerValue iv = interpreter.interpret("1*2");
		assertEquals("1*2", 2, iv.getIntValue().intValue());
	}	
	
	@Test
	public void testMultiply0by2() {
		IntegerValue iv = interpreter.interpret("0*2");
		assertEquals("0*2", 0, iv.getIntValue().intValue());
	}	
	
	@Test
	public void testMultiply1byneg2() {
		IntegerValue iv = interpreter.interpret("1*-2");
		assertEquals("1*-2", -2, iv.getIntValue().intValue());
	}
	@Test
	public void testDivide4by2() {
		IntegerValue iv = interpreter.interpret("4/2");
		assertEquals("4/2", 2, iv.getIntValue().intValue());
	}
	
	@Test
	public void testDivide2by4() {
		IntegerValue iv = interpreter.interpret("2/4");
		assertEquals("2/4", 0.5, iv.getIntValue().intValue());
	}
	
	@Test
	public void testDivide0by2() {
		IntegerValue iv = interpreter.interpret("0/2");
		assertEquals("0/2", 0, iv.getIntValue().intValue());
	}
	@Test
	public void testMinus4minus2() {
		IntegerValue iv = interpreter.interpret("4-2");
		assertEquals("4-2", 2, iv.getIntValue().intValue());
	}	
	@Test
	public void testMinus2minus4() {
		IntegerValue iv = interpreter.interpret("2-4");
		assertEquals("2-4", -2, iv.getIntValue().intValue());
	}
	@Test
	public void testMinus4minus0() {
		IntegerValue iv = interpreter.interpret("4-0");
		assertEquals("4-0", 4, iv.getIntValue().intValue());
	}
	
	@Test
	public void testPlus2andneg3() {
		IntegerValue iv = interpreter.interpret("2+-3");
		assertEquals("2+-3", -1, iv.getIntValue().intValue());
	}	
	
	@Test
	public void testPlusneg2and3() {
		IntegerValue iv = interpreter.interpret("-2+3");
		assertEquals("-2+3", 1, iv.getIntValue().intValue());
	}	
	
	@Test
	public void testPlus2and3() {
		IntegerValue iv = interpreter.interpret("2+3");
		assertEquals("2+3", 5, iv.getIntValue().intValue());
	}	
	
	@Test
	public void testPlus3and2() {
		IntegerValue iv = interpreter.interpret("3+2");
		assertEquals("3+2", 5, iv.getIntValue().intValue());
	}	
	
	@Test
	public void testUnaryMinusExpression() {
		IntegerValue operand = interpreter.interpret("-2");
		assertEquals("-2", 2, operand.getIntValue().intValue());
	}	
	
//	The test covers UnaryMinus, but it fails, but I don't think the program actually
//  ever uses this class the way it's written.  
}
