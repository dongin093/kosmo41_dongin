import java.util.Scanner;

public class Quiz1_TicTacToe {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String user;
		String bowl;
		int num=0;
		String arr[][] = {{"1","2","3"},{"4","5","6"},{"7","8","9"}}; 
		for (int i =0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(j==2) {
					System.out.print(" "+arr[i][j]);
					break;
				}
				System.out.print(" "+arr[i][j] + " |");
			}
			System.out.println();
			if(i==2) {
				System.out.println();
				break;
			}
			System.out.println("---"+" "+"---"+" "+"---");
		}		
		while(true) {
		int count=0;
		// 배열 확인
		while(true) {
			if(num==0) { 
				System.out.println();
				System.out.println("Player 1, please enter the number of the square");
				System.out.println("where you want to place your X:");
				user = s.next();
				for (int i =0;i<arr.length;i++) {
					for(int j=0;j<arr.length;j++) {
						if(user.equals(arr[i][j]))
							arr[i][j] = "X";
					}
			}
			num=1;
			break;
			}
			// Turn Player 2
			if(num==1) {
			System.out.println();
			System.out.println("Player 2, please enter the number of the square");
			System.out.println("where you want to place your O:");
			user = s.next();
			for (int i =0;i<arr.length;i++) {
				for(int j=0;j<arr.length;j++) {
					if(user.equals(arr[i][j]))
						arr[i][j] = "O";
				}
			}
			num=0;
			break;
			}
		}
		// 정답 확인
		for (int i =0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(j==2) {
					System.out.print(" "+arr[i][j]);
					break;
				}
				System.out.print(" "+arr[i][j] + " |");
			}
			System.out.println();
			if(i==2) {
				System.out.println();
				break;
			}
			System.out.println("---"+" "+"---"+" "+"---");
		}
		for(int i =0;i<arr.length;i++) {
			if((arr[i][0]==arr[i][1]&&arr[i][1]==arr[i][2]) || 
			   (arr[0][i]==arr[1][i]&&arr[1][i]==arr[2][i]) ||
			   (arr[0][0]==arr[1][1]&& arr[0][0]==arr[2][2])|| 
			   (arr[2][0]==arr[1][1]&& arr[2][0]==arr[0][2])) {
				if((arr[i][0].equals("X")) || 
				   (arr[0][0].equals("X")) || 
				   (arr[2][0].equals("X"))) 
				{
					count=10;
				}
				else { 
					count=9;
				}
			}
		}
		if(count ==9 ||count==10) {
			for (int i =0;i<arr.length;i++) {
				for(int j=0;j<arr.length;j++) {
					if(j==2) {
						System.out.print(" "+arr[i][j]);
						break;
					}
					System.out.print(" "+arr[i][j] + " |");
				}
				System.out.println();
				if(i==2) {
					System.out.println();
					break;
				}
				System.out.println("------------");
			}
		}
		if(count==10) {
			System.out.println();
			System.out.println("Player 1 has win!");
			break;
		}	
		if(count==9) {
			System.out.println();
			System.out.println("Player 2 has win!");
			break;
		}
		}
	}
}