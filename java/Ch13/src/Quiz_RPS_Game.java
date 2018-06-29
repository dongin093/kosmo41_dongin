import java.util.Random;
import java.util.Scanner;

public class Quiz_RPS_Game {

	public static void main(String[] args) {
		while (true ) {
		Random rnd = new Random();
		Scanner sc = new Scanner(System.in);
		int com = rnd.nextInt(3)+1;
		System.out.println("무엇을 내겠습니까? <1: 가위, 2:바위, 3:보>");
		int uesr = sc.nextInt();
		if (com==uesr) {
			if(com==1) { 
				System.out.println("사용자 : 가위, 컴퓨터 : 가위");
				System.out.println("비겼습니다.");
				continue;
			}
			else if (com==2) { 
				System.out.println("사용자 : 바위, 컴퓨터 : 바위");
				System.out.println("비겼습니다.");
				continue;
			}
			else { 
				System.out.println("사용자 : 보, 컴퓨터 : 보");
				System.out.println("비겼습니다.");
				continue;
			}
		}
		if (com!=uesr) {
			if (com==1 && uesr==2) {
				System.out.println("사용자 : 바위, 컴퓨터 가위");
				System.out.println("이겼습니다.");
				continue;
			}
			if (com==1 && uesr==3) {
				System.out.println("사용자 : 보, 컴퓨터 가위");
				System.out.println("졌습니다.");
				continue;
			}
			if (com==2 && uesr==1) {
				System.out.println("사용자 : 가위, 컴퓨터 바위");
				System.out.println("졌습니다.");
				continue;
			}
			if (com==2 && uesr==3) {
				System.out.println("사용자 : 보, 컴퓨터 바위");
				System.out.println("이겼습니다.");
				continue;
			}
			if (com==3 && uesr==1) {
				System.out.println("사용자 : 가위, 컴퓨터 보");
				System.out.println("이겼습니다.");
				continue;
			}
			if (com==3 && uesr==2) {
				System.out.println("사용자 : 바위, 컴퓨터 보");
				System.out.println("졌습니다.");
				continue;
			}
			
		}
		if(uesr!=1 && uesr!=2 && uesr!=3)
		{
			System.out.println("1,2,3 이외의 숫자를 입력했습니다. ");
			continue;
		}
		}
	}
}