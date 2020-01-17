class MainClass{
	public static void main(String[] args){
		Complex complex1 = new Complex(1,2);
		Complex complex2 = new Complex(3,4);
		Complex sum = Complex.addComplex(complex1,complex2);
		Complex sub = Complex.subtractComplex(complex1,complex2);

		Complex.printComplex(sum);
		Complex.printComplex(sub);
	}
}