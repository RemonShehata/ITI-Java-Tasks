class MainClass {
	
	public static void main(String[] args) {
		Circle s1 = new Circle(5);
		GeoShape s2 = new Rectangle(3,5);
		GeoShape s3 = new Triangle(5,10);
		
		System.out.println(sumArea(s1, s2, s3));
		
	}
	
	static double sumArea(GeoShape g1, GeoShape g2, GeoShape g3) {
		
		return g1.calcArea() + g2.calcArea() + g3.calcArea();
	}
}