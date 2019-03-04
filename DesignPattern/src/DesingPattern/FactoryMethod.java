package DesingPattern;

class Point{
	public double x, y;
	private Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	//Nested classes can contain static methods iff they are static by themselves
	public static class Factory{
		public static Point newCartesian(double x, double y) {
			return new Point(x, y);
		}
		
		public static Point newPolar(double x, double y) {
			return new Point(2.314*x, 2.314*y);
		}
	}
}
