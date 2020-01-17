class Rectangle extends GeoShape {

	int dim2;
	
	public void setDim1(int d) {
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
	
	public Rectangle() {
		System.out.println("Rectangle default constructor!");
		
	}
	
	public Rectangle(int w, int h) {
		
		if(h > 0)
		{
			super.dim1 = h;
		} else {
			super.dim1 = 0;
		}
		
		if(w > 0)
		{
			dim2 = w;
		} else {
			dim2 =  0;
		}
	}
	
	public double calcArea() {
		
		return super.dim1 * dim2;
	}
}