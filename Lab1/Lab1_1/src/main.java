import java.io.*;

public class main {

	public static void main(String[] args) {
		
		int noOfForms = 0;
		Forma []forma = new Forma[101];
		forma[noOfForms++] = new Cerc(10);
		forma[noOfForms++] = new Triunghi(10, 2, 3, 4, 5, 6);
		forma[noOfForms++] = new Patrat(12);
		
		serializeData(forma, noOfForms);		
		forma = null;
		deserializeData(forma, noOfForms);
	}
	
	
	public static void serializeData(Forma forma[], int noOfForms) {
		
		System.out.println("Inainte de serializare: ");
		for (int index = 0; index < noOfForms; index++) {
			System.out.println(forma[index].ComputeArea());
		}
	
		try {
			FileOutputStream fos = new FileOutputStream("forma.ser");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(forma);
		    out.close();
		    fos.close();
		}catch(IOException i){
			i.printStackTrace();
			return;
		}
	}
	
	public static void deserializeData(Forma forma[], int noOfForms) {
		
		try {
	        FileInputStream fis = new FileInputStream("forma.ser");
	        ObjectInputStream in = new ObjectInputStream(fis);
	        forma = (Forma[]) in.readObject();
	        in.close();
	        fis.close();
		}catch (IOException i) {
		     i.printStackTrace();
		     return;
		}catch (ClassNotFoundException c) {
	         System.out.println("Class not found");
	         c.printStackTrace();
	         return;
	    }
		System.out.println("Dupa deserializare: ");
		for (int index = 0; index < noOfForms; index++) {
			System.out.println(forma[index].ComputeArea());
		}
		
	}
}
