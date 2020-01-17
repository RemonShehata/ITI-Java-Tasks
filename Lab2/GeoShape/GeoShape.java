class GeoShape{
	int dim1;
	
	public void setDim1(int d) {
		if(d > 0)
		{
			dim1 = d;
		} else {
			dim1 =  0;
		}
	}
	
	public int getDim1(){
		return dim1;
	}
	
	public GeoShape(){
		System.out.println("GeoShape Default constructor");
		dim1 = 0;
	}
	
	public GeoShape(int d) {
		if(d > 0)
		{
			dim1 = d;
		} else {
			dim1 =  0;
		}
	}
	
	public double calcArea() {
		
		return 0;
	}
}