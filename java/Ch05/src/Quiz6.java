import java.util.Scanner;

public class Quiz6 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("원하는 구구단 숫자를 입력하시오.");
		int num = s.nextInt();
		for(int j = 9;j>0;j--) { 
			System.out.println(num + "x" + j + "=" + (num*j));
		}
		
		
	}

}
