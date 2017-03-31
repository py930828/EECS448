package classFiles;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {
	@Test
	public void determinanttest() {
		Matrix test = new Matrix(2);
		test.build(5, 0, 0);
		test.build(2, 0, 1);
		test.build(3, 1, 0);
		test.build(5, 1, 1);
		assertEquals( 19.0, test.determinant(), 0.001 );
	}
	
	@Test
	public void inversetest() {
		Matrix test = new Matrix(2);
		test.build(5, 0, 0);
		test.build(2, 0, 1);
		test.build(3, 1, 0);
		test.build(5, 1, 1);
		Matrix test2 = test.inverse();
		Matrix test1 = new Matrix(2);
		test1.build(0.2631, 0, 0);
		test1.build(-0.105, 0, 1);
		test1.build(-0.15789, 1, 0);
		test1.build(0.263157, 1, 1);
		for(int i = 0; i<2; i++){
			for(int j = 0; j<2; j++)
			{
				assertEquals(((test.inverse()).getMat(i,j)), test1.getMat(i, j), 0.001 );
			}
		}
	}
		@Test
		public void testsubMatrix() {
			Matrix test = new Matrix(3);
			test.build(5, 0, 0);
			test.build(2, 0, 1);
			test.build(3, 0, 2);
			test.build(5, 1, 0);
			test.build(6, 1, 1);
			test.build(7, 1, 2);
			test.build(4, 2, 0);
			test.build(4, 2, 1);
			test.build(8, 2, 2);
			Matrix sub = test.subMatrix(1,1);
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < 2; j++)
				{
					System.out.println(sub.getMat(i,j));
				}
			}
			Matrix test1 = new Matrix(2);
			test1.build(5, 0, 0);
			test1.build(3, 0, 1);
			test1.build(4, 1, 0);
			test1.build(8, 1, 1);
			for(int i = 0; i < 2; i++)
			{
				for(int j = 0; j < 2; j++)
				{
					assertEquals(sub.getMat(i,j), test1.getMat(i, j), 0.001 );
				}
			}
	}

}
