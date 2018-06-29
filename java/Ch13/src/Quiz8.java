import java.util.Scanner;

public class Quiz8 {

	public static void main(String[] args) {
		String[][] amn={ {"구분","이순신","강감찬","을지문","권율","총점"},
						 {"국어"},
						 {"영어"},
						 {"수학"},
						 {"국사"},
						 {"총점"}
						};
		Scanner s = new Scanner(System.in);
		int [][] arr = new int[5][5];
		int sum1=0;
		int sum2=0;
		for (int i=0;i<4;i++) {
			for (int j=0;j<4;j++) { 
			System.out.println(amn[0][i+1]+"의 " + amn[j+1][0] +  " 점수를 입력하시오.");
			int num = s.nextInt();
			arr[j][i]=num;
			sum1 +=arr[j][i];
			}
			arr[4][i] = sum1;
			sum1=0;
		}
		for (int i = 0;i<6;i++) {
			System.out.print(amn[0][i]+"\t");
		}
		System.out.println();
		for (int i =0; i<5;i++) { 
			System.out.print(amn[i+1][0] + "\t");
			for(int j = 0;j<4;j++) {
				System.out.print(arr[i][j] + "\t");
				sum2 += arr[i][j];
			}
			System.out.println(sum2);
			sum2=0;
		}
	}
}