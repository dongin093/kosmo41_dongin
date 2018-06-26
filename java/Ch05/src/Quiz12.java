
public class Quiz12 {

	public static void main(String[] args) {
		int num = 1;
		int sum = 1;
		System.out.print(num);
		do {
			num++;
			System.out.print("+" + num + "");
			sum+=num;		
			}while(num<1000);
		System.out.println("=");
		System.out.println(sum);

	}
}

