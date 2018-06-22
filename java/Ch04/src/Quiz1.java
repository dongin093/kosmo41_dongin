import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
		
		System.out.println("첫 번째 숫자를 입력하세요.");
		
		int num1 = s.nextInt();
		
		System.out.println("두 번째 숫자를 입력하세요.");
		
		int num2 = s.nextInt();
		
		System.out.println("당신이 입력한 숫자의 합 = " + (num1 + num2));
		System.out.println("당신이 입력한 숫자의 뺼셈 = " + (num1 - num2));
		System.out.println("당신이 입력한 숫자의 곱셈 = " + (num1 * num2));
		System.out.println("당신이 입력한 숫자의 나눗셈 = " + (num1 / num2));

	}
}