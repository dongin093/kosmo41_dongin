import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요.");
		
		int num1 = s.nextInt();
		
		System.out.println("당신이 입력한 숫자의 제곱은 " + (num1 * num1));
	}

}
