import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		String arr[][] = { {"1","2","3"},
				           {"4","5","6"},
					       {"7","x","8"} };
		String bowl;
		String user;
		while (true) {
			for (int i =0;i<3;i++) {
			for (int j=0; j<3;j++) {
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
			}
			System.out.println();
			System.out.println("[Move] a:Left s:Right w:Up z:Down");
			System.out.println("[Exit] k:Exit");
			System.out.println("이동키를 입력하세요 : ");
			user = s.next();
			bowl = user;
			if (user.equals("a")) {
				System.out.println();
				continue;
			}
			if (user.equals("s")) {
			System.out.println();
			continue;
			}
//			if (user.equals("k")) {
//				System.out.println("게임을 종료합니다.");
//				System.out.println("Good Bye~");
//				break;
//			}
			if (user.equals("k")) {
				System.out.println("게임을 종료합니다.");
				System.out.println("Good Bye~");
				break;
			}
		}
		
		

	}

}
