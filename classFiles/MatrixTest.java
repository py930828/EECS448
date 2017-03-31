package classFiles;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {

	@Test
	public void test() {
		Matrix test = new Matrix(2);
		test.build(5, 0, 0);
		test.build(2, 0, 1);
		test.build(3, 1, 0);
		test.build(5, 1, 1);
		assertEquals( 12.0, test.determinant(), 0.001 );
	}

}
