import java.util.Scanner;

public class Quiz8 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		
		int sum = 0;
		for(int i= 1;i<6;) {
			System.out.println("������ �Է��Ͻÿ�.");
			int num1 = s.nextInt();
			if(num1<1) {
				System.out.println("1�̸� �ԷºҰ�. ���Է¿�.");
				continue;
			}
			i++;
			sum=sum+num1;
		}	
		System.out.println("�Է°��� ����"+ sum);
		}
	}
