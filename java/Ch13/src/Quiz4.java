
import java.util.Scanner;

public class Quiz4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); 
		int [] num = new int[10];
		System.out.println("총 10개의 정수를 입력하시오.");
		for(int i = 0;i<num.length;i++)
		{
			num[i] = s.nextInt();
						
		}
		System.out.print("출력값 : ");
		for(int i = 0;i<num.length;i++) 
		{
			if ((num[i]%2)!=0)
			{
				System.out.print(num[i]+ " ");
			}
		}
		for(int i = 9;i>=0;i--)
		{
			if ((num[i]%2)==0) {
			System.out.print(num[i]+ " ");
		}
		}		

	}

}