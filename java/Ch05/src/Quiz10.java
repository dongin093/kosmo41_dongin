import java.util.Scanner;

public class Quiz10 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("����2���� �Է��Ͻÿ�.");
		int num1=s.nextInt();
		int num2=s.nextInt();
		int sum=num1;
		System.out.print(num1);
		for(int i=num1+1;i<=num2;i++) {
			sum=sum+i;
			System.out.print("+"+i);
		}
		System.out.println(" = " +sum);
	}

}
