import java.util.Scanner;

public class Quiz4 {

	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
		int num;
		int sum = 0;
		do {
			System.out.println("���ڸ� �Է��ϼ���.");
			
			num = s.nextInt();
            sum = sum + num;		
		
	    } while(num != 0);
	   
		System.out.println(sum);
	   
	}

}
