import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		int num = 0;
		int sum = 0;
		int i=1;
		System.out.println("�Է��� ������ ���� ���Ͻÿ�");
		int count = s.nextInt();
		while (count>=i) {
			System.out.println(i + "��° ���ڸ� �Է��Ͻÿ�.");
			num =s.nextInt();
			sum=sum+num;
			i++;
		}
		System.out.println("�Է��Ѽ��� ��հ�" + "=" + sum/(double)count);
	}
}
