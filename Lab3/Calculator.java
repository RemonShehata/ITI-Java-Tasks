class Calculator {

	public static void main(String[] args) {
		
		if(args.length == 3) {
			
			int firstNum = Integer.parseInt(args[0]);
			int secondNum = Integer.parseInt(args[2]);
		
		switch (args[1]) {
			
			case "+" :
				System.out.println(firstNum + secondNum);
			break;
			
			case "-" :
				System.out.println(firstNum - secondNum);
			break;
			
			case "*" :
				System.out.println(firstNum * secondNum);
			break;
			
			case "/" :
			
				if(secondNum > 0) {
					System.out.println(firstNum / secondNum);
				}else {
					System.out.println("cannot divide by zero!");
				}
				
			break;
			
			default:
				System.out.println("Wrong operator!");
			break;
		}
			
		} else {
			
			System.out.println("enter 2 operands and 1 operator!");
		}
		
		
		
	}
}