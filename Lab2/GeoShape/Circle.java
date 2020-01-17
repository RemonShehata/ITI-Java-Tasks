class Circle extends GeoShape {
	
	public Circle() {
		System.out.println("Circle Default constructor!");
	}
	
	public Circle(int r) {
		super(r);
	}
	
	public double calcArea() {
		
		return 3.14 * super.dim1 * super * dim1;
	}
}