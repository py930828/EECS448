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
	void build(double num, int row, int column )
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
	public Matrix subMatrix(int r, int c)
	{
		Matrix sub = new Matrix(size - 1);
		System.out.println("size is "+size);
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
		double det = determinant();
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
	public double getInverse( int row, int column)
	{
		return mat[row][column];
	}
	public String GetDet()
	{
		return Double.toString(det);
	}
	public double getMat(int row, int column)
	{
		return mat[row][column];
	}

}
