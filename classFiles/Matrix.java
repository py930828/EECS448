package classFiles;
import java.io.*;
import java.util.Scanner;
import java.util.Scanner;
import java.util.Scanner;
public class Matrix {
	private int size;
	private double det;
	double[][] mat;
	public Matrix(int n){
		// check size
		size = n;	
		mat = new double[size][size];
		
	}
	void build(int num, int row, int column )
	{
		mat[row][column] = num;
	}
	public double determinant()
	{
		if (size == 1)
		{
			det = mat[0][0];
		}
		else if (size == 2)
		{
			det = mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
		}
		else
		{
			for (int i = 0; i < size; ++i)
			{
				det += Math.pow(-1.0, (double)i) * mat[0][i] * subMatrix(0, i).determinant();
			}
		}
		return det;
	}
	private Matrix subMatrix(int r, int c)
	{
		Matrix sub = new Matrix(size - 1);
		int row = 0; 
		for (int i = 0; i < size; ++i)
		{
			if (i == r) continue;
			
			int col = 0;
			for (int j = 0; j < size; ++j)
			{
				if (j == c) continue;
				
				sub.mat[row][col] = mat[i][j];
				++col;
			}
			++row;
		}
		return sub;
	}
	public Matrix inverse()
	{
		Matrix inv = new Matrix(size);
		for (int i = 0; i < size; ++i)
		{
			for (int j = 0; j < size; ++j)
			{
				inv.mat[i][j] = Math.pow(-1.0, (double)i + j) * subMatrix(j, i).determinant() / det;
			}
		}
		return inv;
	}
	public String getInverse( int row, int column)
	{
		return Double.toString(mat[row][column]);
	}
	public String GetDet()
	{
		return Double.toString(det);
	}
	public 
	String getMat(int row, int column)
	{
		return Double.toString(mat[row][column]);
	}

}
