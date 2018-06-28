import java.util.Scanner;
import java.util.Random;

public class Quiz1401 {

	public static void main(String[] args) {
		Random rnd = new Random();
		Scanner sc = new Scanner(System.in);
		while (true) {
		int num = rnd.nextInt(101);
		int count = 6;
		String Y = "n";
		System.out.println("나는 지금 0부터 100사이 값 중에 하나를 생각하겠습니다.");
		System.out.println("당신은 그 숫자를 6회안에 맞추시면 됩니다.");
		System.out.println("몇이라고 생각합니까? <0 to 100>");
		for (int i =1;i<7;i++) {
			int in = sc.nextInt();
			if (count-1==0) { 
				System.out.println();
				System.out.println("주어진 기회를 모두 소진하셨습니다.");
				break;
			}
			if (num==in) { 
				System.out.println(in + "는 정답입니다. 축하합니다.");
				break;
			}
			if (num>in) {
				count--;
				System.out.println(in + "는 제가 정한 숫자보다 작습니다.");
				System.out.println(count + "번의 기회가 남았습니다.");
			}
			if (num<in) {
				count--;
				System.out.println(in + "는 제가 정한 숫자보다 큽니다.");
				System.out.println(count + "번의 기회가 남았습니다.");
			}
		}
		System.out.println("High / Low 게임을 플레이해 주셔서 감사합니다.");
		System.out.println("다시하시겠습니까 ? <Y/N>");
		Y = sc.next();
		if (Y.equals("n")) {
			break;
		}
		else { 
			continue;
		}
	}
		System.out.println("Good Bye");
	}
}