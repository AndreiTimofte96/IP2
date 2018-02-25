
public class Cerc extends Forma{
	
	public int raza;
	
	Cerc( int raza){
		this.raza = raza;
	}
	
	public double ComputeArea() {
		return 3.14 * this.raza * this.raza;
	}
}
