import java.util.Random;
import java.util.Scanner;

public class Quiz_BaseballGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
		int [] arr = new int[3];
		int com1 = 0;
		int com2 = 0;
		int com3 = 0;
		for(;;) {
			com1 = rnd.nextInt(9)+1;
			com2 = rnd.nextInt(10);
			com3 = rnd.nextInt(10);
			if(com1!=com2&&com1!=com3&&com2!=com3) {
				arr[0] = com1;
				arr[1] = com2;
				arr[2] = com3;
				break;
			}
		}
		System.out.println("숫자로 하는 야구게임시작");

		for(int i =1;;i++) {
			System.out.println("세자리 숫자를 입력하세요."+ i +"회");
			int x=0;
			int y=0;
			int num = sc.nextInt();
			com1 = (num/100);
			com2 = (num%100)/10;
			com3 = num%100%10;
			if (com1 == arr[0]) { 
				x++;
			}
			if (com2 == arr[1]) { 
				x++;
			}
			if (com3 == arr[2]) { 
				x++;
			}
			if (com1 == arr[2] || com1 ==arr[1]) { 
				y++;
			}
			if (com2 == arr[0] || com2 ==arr[2]) { 
				y++;
			}
			if (com3 == arr[1] || com3 ==arr[0]) { 
				y++;
			}
			if(x==3) {
				System.out.println((com1)+":"+(com2)+":"+(com3));
				System.out.println("You Win");
				break;
			}
			System.out.println((com1)+":"+(com2)+":"+(com3));
			System.out.println(x + " Strike " + y + " ball ");
		}
	}
}