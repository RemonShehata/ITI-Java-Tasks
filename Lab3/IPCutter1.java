class IPCutter1 {

	public static void main(String[] args) {
		//String ip = args[0];
		String ip ="163.121.12.30";
		
		int indexBegin = 0;
		int indexEnd = ip.indexOf(".", 0);
		
		
		while(indexEnd > 0) {
			
			System.out.println(ip.substring(indexBegin,indexEnd));
			indexBegin = indexEnd + 1;
			
			indexEnd = ip.indexOf(".", indexBegin);
			
		}
		System.out.println(ip.substring(indexBegin,ip.length()));
		/*System.out.println(indexBegin);
		System.out.println(indexEnd);*/
	}
}