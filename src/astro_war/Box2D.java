package astro_war;

public class Box2D {
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	
	public boolean crashCheck(int x, int y, int width) {
		if(this.x - width <= x && this.x + this.width >= x) {
			//System.out.println("x crash");
			if(this.y <= y && this.y + height >= y) {
				//System.out.println("y crash");
				return true;
			}
		}
		return false;
	}
}
