import java.util.StringTokenizer;
class IPCutter3 {
	
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("163.121.12.30");
		 while (st.hasMoreTokens()) {
			 System.out.println(st.nextToken("."));
		 }

	}

}