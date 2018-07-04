import java.util.Random;
import java.util.Scanner;


public class Quiz1 {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		Random rnd = new Random();
		
		String arr[][] = { {"1","2","3"},
				           {"4","5","6"},
					       {"7","8","x"} };
		String ok[][] = { {"1","2","3"},
						  {"4","5","6"},
						  {"7","x","8"} };
		String bowl;
		String user;
		//셔플
		for(int k = 0; k<100 ;k++) {
			int n = (int) (Math.random()*4);
			if (n==0) {
				for (int i =0;i<arr.length;i++) {
					for (int j=0; j<arr.length;j++) {
						if (arr[i][j].equals("x")) {
							if(j==0) {
								break;
							}
							bowl=arr[i][j];
							arr[i][j]=arr[i][j-1];
							arr[i][j-1] = bowl;					
						}
					}
				}
			}
			if (n==1) {
				for (int i =0;i<arr.length;i++) {
					for (int j=0; j<arr.length;j++) {
						if (arr[i][j].equals("x")) {
							if(j==2) {
								break;
							}
							bowl=arr[i][j];
							arr[i][j]=arr[i][j+1];
							arr[i][j+1] = bowl;			
						}
					}
				}
			}
			if (n==2) {
				for (int i =0;i<arr.length;i++) {
					for (int j=0; j<arr.length;j++) {
						if (arr[i][j].equals("x")) {
							if(i==0) {
								break;
							}
							bowl=arr[i][j];
							arr[i][j]=arr[i-1][j];
							arr[i-1][j] = bowl;				
						}
					}
				}
			}
			if (n==3) {
				for (int i =0;i<arr.length;i++) {
					for (int j=0; j<arr.length;j++) {
						if (arr[i][j].equals("x")) {
							if(i==2) {
								break;
							}
							bowl=arr[i][j];
							arr[i][j]=arr[i+1][j];
							arr[i+1][j] = bowl;				
						}
					}
				}
			}
		}
		
		//반복게임
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
			for (int i =0;i<arr.length;i++) {
				for (int j=0; j<arr.length;j++) {
					if (arr[i][j].equals("x")) {
						xi=i;
						yj=j;						
					}
				}
			}
			
			//이동키
			if (user.equals("a")) {
				if ((xi==0 && yj==0) || (xi==1&& yj==0)|| (xi==2&& yj==0)) {
					System.out.println("잘못입력했습니다.");
					continue;
				}
				bowl=arr[xi][yj];
				arr[xi][yj]=arr[xi][yj-1];
				arr[xi][yj-1] = bowl;
				System.out.println();
			}
			if (user.equals("s")) {
				if ((xi==0 && yj==2) || (xi==1&& yj==2)|| (xi==2&& yj==2)) {
					System.out.println("잘못입력했습니다.");
					continue;
				}
				bowl=arr[xi][yj];
				arr[xi][yj]=arr[xi][yj+1];
				arr[xi][yj+1] = bowl;
				System.out.println();
			}
			if (user.equals("w")) {
				if ((xi==0 && yj==0) || (xi==0&& yj==1)|| (xi==0&& yj==2)) {
					System.out.println("잘못입력했습니다.");
					continue;
				}
				bowl=arr[xi][yj];
				arr[xi][yj]=arr[xi-1][yj];
				arr[xi-1][yj] = bowl;
				System.out.println();
			}
			if (user.equals("z")) {
				if ((xi==2 && yj==0) || (xi==2&& yj==1)|| (xi==2&& yj==2)) {
					System.out.println("잘못입력했습니다.");
					continue;
				}
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
			//정답
			for(int i=0;i<3;i++) {
				for(int j =0; j<3;j++) {
					if (arr[i][j].equals(ok[i][j])) {
						count++;
					}
				}
			}
			if(count>=9)
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