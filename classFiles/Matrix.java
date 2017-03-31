package classFiles;
import java.io.*;
import java.util.Scanner;
import java.util.Scanner;
import java.util.Scanner;
public class Matrix {
	private int size;
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
	String getMat(int row, int column)
	{
		return Double.toString(mat[row][column]);
	}

}
