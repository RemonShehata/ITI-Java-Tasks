class IPCutter2 {
	
	public static void main(String[] args) {
		//https://stackoverflow.com/questions/15310505/manipulating-ip-addresses-split-string-on-character
		//String ip = args[0];
		String ip ="163.121.12.30";
		String[] arr =  ip.split("\\.");
		for(String element : arr) {
			System.out.println(element);
		}
	}	
}