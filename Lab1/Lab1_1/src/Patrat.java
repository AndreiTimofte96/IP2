
public class Patrat extends Forma{
	
	public int latura;
	private static final long serialVersionUID = 1L;
	
	Patrat (int latura){
		this.latura = latura;
	}
	
	public double ComputeArea() {
		return latura*latura;
	}
	
	

}
