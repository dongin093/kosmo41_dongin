import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
//		String arr[][] = { {"1","2","3"},
//				           {"4","5","6"},
//					       {"7","8","x"} };
		String ok[][] = { {"1","2","3"},
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
			int xi=0;
			int yj=0;
			int count = 1;
			for (int i =0;i<3;i++) {
				for (int j=0; j<3;j++) {
					if (arr[i][j].equals("x")) {
						xi=i;
						yj=j;						
					}
				}
			}
			for(int i=0;i<3;i++) {
				for(int j =0; j<3;j++) {
					if (arr[i][j]==ok[i][j]) {
						count++;
					}
				}
			}
			
			if (user.equals("a")) {
				bowl=arr[xi][yj];
				arr[xi][yj]=arr[xi][yj-1];
				arr[xi][yj-1] = bowl;
				System.out.println();
			}
			if (user.equals("s")) {
				bowl=arr[xi][yj];
				arr[xi][yj]=arr[xi][yj+1];
				arr[xi][yj+1] = bowl;
				System.out.println();
			}
			if (user.equals("w")) {
				bowl=arr[xi][yj];
				arr[xi][yj]=arr[xi-1][yj];
				arr[xi-1][yj] = bowl;
				System.out.println();
			}
			if (user.equals("z")) {
				bowl=arr[xi][yj];
				arr[xi][yj]=arr[xi+1][yj];
				arr[xi+1][yj] = bowl;
				System.out.println();
			}
			if (user.equals("k")) {
				System.out.println("게임을 종료합니다.");
				System.out.println("Good Bye~");
				break;
			}
			if(count==8)
			{
				for (int i =0;i<3;i++) {
					for (int j=0; j<3;j++) {
					System.out.print(arr[i][j] + "  ");
					}
					System.out.println();
				}
				System.out.println();
				System.out.println("정답입니다. 게임을 종료합니다.");
				System.out.println("Good Bye~");
				break;
			}
		}
	}
}