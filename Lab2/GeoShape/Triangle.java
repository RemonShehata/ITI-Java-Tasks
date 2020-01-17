class Triangle extends GeoShape {

	int dim2;
	
	public void setDim2(int d) {
		if(d > 0)
		{
			dim2 = d;
		} else {
			dim2 =  0;
		}
	}
	
	public int getDim2(){
		return dim2;
	}
	
	public Triangle() {
		System.out.println("Triangle Default Constructor!");
	}
	
	public Triangle(int d1, int d2) {
		
		if(d1 > 0)
		{
			super.dim1 = d1;
		} else {
			super.dim1 = 0;
		}
		
		if(d2 > 0)
		{
			dim2 = d2;
		} else {
			dim2 =  0;
		}
	}
	
	public double calcArea() {
		
		return dim1 * dim2 / 2;
	}
	
}