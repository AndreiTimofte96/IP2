import java.text.DecimalFormat;
import java.io.*;
import java.util.Scanner;

public class main {
	
	static double val;
	static double []valuesX = new double[101];
	static double []valuesY = new double[101];
	static double []newValuesY = new double[101];
	static String [][]graph = new String[101][101];
	static int a = 1, b = 3, c = 1;
	static double min, max, step;
	static int index, space, kVal, noOfValues;
	static DecimalFormat df = new DecimalFormat("0.00"); // Set your desired format here.
	static boolean[] use = new boolean[101];
	static boolean isMinus = false;
	
	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a: ");
		a = reader.nextInt(); // Scans the next token of the input as an int.
		System.out.println("Enter b: ");
		b = reader.nextInt(); // Scans the next token of the input as an int.
		System.out.println("Enter c: ");
		c = reader.nextInt(); // Scans the next token of the input as an int.
		//once finished
		reader.close();
		
		
		readData();	
		findYValues();
		validateYValues();
		sortYValues();
//		for (int i = 0; i < kVal; i++) {
//			System.out.print(newValuesY[i] + " ");
//		}System.out.println();
//		
		createMatrix();
		drawAll();
		
		System.out.println();
	}
	
	public static void createMatrix() {
		
		double val;
		int i, j;
		
		for (i = 0; i < noOfValues; i++) {
			for (j = 0; j < kVal; j++) {
				graph[i][j]="-";
			}
		}
		
		for (i = 0; i < noOfValues; i++) {
			val = functionValue(valuesX[i]);
			for (j = 0; j < kVal; j++) {
				if (newValuesY[j] == val) {
					break;
				}
			}
			graph[i][j] = "*";
		}
	}
	public static void readData() {
		
		File file = new File("param.txt");
		BufferedReader reader = null;

		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;
		    
		    min = Double.parseDouble(reader.readLine());
		    max = Double.parseDouble(reader.readLine());
		    step = Double.parseDouble(reader.readLine());

		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {
		    }
		}
		
	}
	public static void sortYValues() {
		
		boolean ok = true;
		double aux;
		while (ok) {
			ok = false;
			for (int i = 0; i < kVal -1 ; i++) {
				if (newValuesY[i] < newValuesY[i+1]) {
					ok = true;
					aux = newValuesY[i];
					newValuesY[i] = newValuesY[i+1];
					newValuesY[i+1] = aux;
				}
			}
		}
	}
	
	public static void findYValues() {
		
		val = min;
		for (index = 0; val <= max; val = Math.round((val+step)*100) / 100.0, index++) {
			
			valuesX[index] = val;
			valuesY[index] = Math.round(functionValue(val) * 100) / 100.0;
			if (valuesY[index] < 0) isMinus = true;
			//System.out.print(valuesY[index] + " "); 
		}
		noOfValues = index; 
		System.out.println();	
	}
	
	public static void validateYValues() {
		int noOfValues = index;
		for (int i = 0; i < noOfValues; i++) {
			for (int j = i+1; j < noOfValues; j++) {
				if (valuesY[i] == valuesY[j]) {
					use[j] = true;
					break; 
				}
			}
		}
		
		for (int i = 0; i < noOfValues; i++) {
			if (use[i] == false) {
				newValuesY[kVal++] = valuesY[i];
				//System.out.print(valuesY[i] + " ");
			}
		}
		System.out.println();
	}
	
	
	public static void drawAll() {
		
		int i, j, k;
		double val;
//		for (i = 0; i < kVal; i++) {
//			for (j = 0; j < noOfValues; j++) {
//				System.out.print(graph[j][i]);
//			}
//			System.out.println();
//		}
		
		int yyy = (int) Math.round( (7*(max-min)/step) / ((max-min)/step) - 1);
		System.out.println(yyy);
		
		for (i = 0; i < kVal; i++) {
			
			val = newValuesY[i];
			if (isMinus == true && val > 0) {
				System.out.printf(" ");
			}
			System.out.print(df.format(val)+ "|   ");
			for (j = 0; j < noOfValues; j++) {
				System.out.print(graph[j][i]);
				
				
				for (k = 0; k < yyy; k++)
					System.out.print(" ");	
			}
			
			System.out.println();
			System.out.println();
		}
		 
		
		// X-VAL
		System.out.print("      ");
		for (index = 0; index < 8*(max-min)/step ; index++ ) {
			System.out.print("-");
		}
		System.out.println();
		System.out.print("      ");
		for (index = 0; index < noOfValues; index++ ) {
			if (isMinus == true) {
				System.out.print(" ");
			}
			System.out.print(valuesX[index] + "   ");
		}
		///////////
	}
	
	public static double functionValue(double x) {
		return Math.round((a*x*x + b*x + c)*100) / 100.0;
	}
	
}

