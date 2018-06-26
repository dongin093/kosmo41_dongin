import java.util.Scanner;

public class Quiz11 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("정수를 입력하시오.");
		int num = s.nextInt();		
		int sum = 1;
		while(num>0) { 
			sum = sum*num;
			num--;
		}
		System.out.println("입력한 정수의 팩토리얼은 : ");
		System.out.println(sum);

	}

}
