
import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); 
		int [] num = new int[10];
		for(int i = 0;i<num.length;i++)
		{
			System.out.println((i+1)+"번째 숫자를 입력하시오.");
			num[i] = s.nextInt();
						
		}
		System.out.print("홀수출력 : ");
		for(int i = 0;i<num.length;i++) 
		{
			if ((num[i]%2)!=0)
			{
				System.out.print(num[i]+ " ");
			}
		}
		System.out.println();
		System.out.print("짝수출력 : ");
		for(int i = 0;i<num.length;i++)
		{
			if ((num[i]%2)==0) {
			System.out.print(num[i]+ " ");
		}
		}		

	}

}
