
public class Triunghi extends Forma{
	private static final long serialVersionUID = 1L;
	public int x1, x2, x3, y1, y2, y3;
	
	Triunghi(int x1, int y1, int x2, int y2, int x3, int y3) {
		
		this.x1 = x1; this.x2 = x2; this.x3 = x3;
		this.y1 = y1; this.y2 = y2; this.y3 = y3;
	}
	
	public double ComputeArea() {
		
		int det; 
		det = x1*y2 + x2*y3 + y1*x3 - y2*x3 - x1*y3 - x2*y1;
		return Math.abs(det) / 2;
	}
}
