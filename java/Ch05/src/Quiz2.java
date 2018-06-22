import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		int num = 0;
		int sum = 0;
		int i=1;
		System.out.println("입력할 정수의 수를 정하시오");
		int count = s.nextInt();
		while (count>=i) {
			System.out.println(i + "번째 숫자를 입력하시오.");
			num =s.nextInt();
			sum=sum+num;
			i++;
		}
		System.out.println("입력한수의 평균값" + "=" + sum/(double)count);
	}
}
