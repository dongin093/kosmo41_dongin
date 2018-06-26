
public class Quiz1 {
	int sum = 0;
	
	public static void main(String[] args) {
		System.out.println("AZ + ZA = 99 만족하는 값은");
		for (int i=0;i<100;i++) {
			for (int j=0;j<10;j++)
			if((i+j)==9) {
				System.out.println(" "+ i + j);
				System.out.println("+"+j+i);
				System.out.println("----------");
				System.out.println(" 99");
				System.out.println();
			}
		}

	}

}