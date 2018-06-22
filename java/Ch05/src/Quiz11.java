import java.util.Scanner;

public class Quiz11 {

	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		System.out.println("하나의정수를 입력하시오.");
		int num=s.nextInt();
		int i =num;
		int sum=1;
		while(i<=1) {
			while(i>1) {
				sum*=i;
				i--;
			}
		}
		System.out.println(sum);
	}

}
