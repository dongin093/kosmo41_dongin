import java.util.Scanner;

public class Quiz8 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		
		int sum = 0;
		for(int i= 1;i<6;) {
			System.out.println("정수를 입력하시오.");
			int num1 = s.nextInt();
			if(num1<1) {
				System.out.println("1미만 입력불가. 재입력요.");
				continue;
			}
			i++;
			sum=sum+num1;
		}	
		System.out.println("입력값의 합은"+ sum);
		}
	}
