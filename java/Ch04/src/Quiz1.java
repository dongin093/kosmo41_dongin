import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
		
		System.out.println("ù ��° ���ڸ� �Է��ϼ���.");
		
		int num1 = s.nextInt();
		
		System.out.println("�� ��° ���ڸ� �Է��ϼ���.");
		
		int num2 = s.nextInt();
		
		System.out.println("����� �Է��� ������ �� = " + (num1 + num2));
		System.out.println("����� �Է��� ������ �E�� = " + (num1 - num2));
		System.out.println("����� �Է��� ������ ���� = " + (num1 * num2));
		System.out.println("����� �Է��� ������ ������ = " + (num1 / num2));

	}
}