public class Complex{
	private int img;
	private int real;
	
	Complex(int i, int r){
		if(i < Integer.MAX_VALUE && r < Integer.MAX_VALUE &&
		i > Integer.MIN_VALUE && i > Integer.MIN_VALUE) {
			img = i;
			real = r;
		} else {
			img = 0;
			real = 0;
		}
	}
	
	
	public static Complex addComplex(Complex firstComp, Complex secondComp) {
		int i = firstComp.img + secondComp.img;
		int r = firstComp.real + secondComp.real;
		Complex retComplex = new Complex(i,r);
		
		return retComplex;
	}
	
	public static Complex subtractComplex(Complex firstComp, Complex secondComp) {
		int i = firstComp.img - secondComp.img;
		int r = firstComp.real - secondComp.real;
		Complex retComplex = new Complex(i,r);
		
		return retComplex;
	}
	
	public static void printComplex(Complex comp){
		if(comp.img > 0 && comp.real > 0) {
			System.out.println(comp.real + " + " + comp.img + "i");
		} else if(comp.img == 0 && comp.real == 0){
			System.out.println("i");
		} else if(comp.img == 0 && comp.real > 0) {
			System.out.println(comp.real + " + " + "i");
		} else if (comp.img < 0 && comp.real < 0) {
			System.out.println(comp.real + " " +comp.img + "i");
		}
	}
	
}