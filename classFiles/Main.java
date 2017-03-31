package classFiles;
import java.io.*;
import java.util.Scanner;
import java.util.Scanner;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.dir"));
		double det;
		if(args.length < 2)
		{
			System.out.println("Error - Expected usage: ./main input.txt output.txt");
			System.exit(0);
		}
		Scanner sc = null;
		try {
			
			File read = new File(args[0]);
			sc = new Scanner(read);
			FileWriter out = new FileWriter(args[1]);
			int size;
			while(sc.hasNextLine()){
				size = sc.nextInt();
				//check the size of the Matrix
				if(size <= 0)
				{
					break;
				}
				// building the Matrix
				Matrix m = new Matrix(size);
				for(int i = 0; i < size; i++)
				{
					for(int j = 0; j < size; j++)
					{
						m.build(sc.nextInt(), i, j);
					}
				}
				// Printing the Matrix
				out.write("M = "+ "\r\n");
				for(int i = 0; i < size; i++){
					for(int j = 0; j < size; j++)
					{
						out.write(m.getMat(i,j));
						out.write(" ");
					}
					out.write("\r\n");
				}
				// printing the determinant
				det = m.determinant();
				out.write("det(M) = " + m.GetDet() + "\r\n");
				if (m.GetDet() != "0")
				{
					Matrix inverse = m.inverse();
					out.write("M inverse = " + "\r\n");
					for(int i = 0; i < size; i++){
						for(int j = 0; j < size; j++)
						{
							out.write(inverse.getMat(i, j));
							out.write(" ");
						}
						out.write("\r\n");
					}
				}
			}
			
			out.write("Done!");
			sc.close();
			out.close();
			
		}catch (Exception e){
			System.out.println("Could not find input file: %s"+args[0]);
			e.printStackTrace();
		}
	}
}
