import java.util.Scanner;

public class Quiz11 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("������ �Է��Ͻÿ�.");
		int num = s.nextInt();		
		int sum = 1;
		while(num>0) { 
			sum = sum*num;
			num--;
		}
		System.out.println("�Է��� ������ ���丮���� : ");
		System.out.println(sum);

	}

}
