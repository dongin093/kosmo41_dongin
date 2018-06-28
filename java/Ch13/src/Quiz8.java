import java.util.Scanner;

public class Quiz8 {

	public static void main(String[] args) {
		String[][] amn={ {"구분","이순신","강감찬","을지문덕","권율","총점"},
						 {"국어"},
						 {"영어"},
						 {"수학"},
						 {"국사"},
						 {"총점"}
						};
		Scanner s = new Scanner(System.in);
		int [][] arr = new int[5][5];
		int sum=0;
		for (int i=0;i<4;i++) {
			for (int j=0;j<4;j++) { 
			System.out.println(amn[0][i+1]+"의 " + amn[j+1][0] +  " 점수를 입력하시오.");
			int num = s.nextInt();
			arr[i][j]=num;
			}
		}
		for (int i=0;i<5;i++) {
				System.out.print(amn[0][i] + "\t");	
		}
		System.out.println();
		
		System.out.print(amn[1][0] + "\t");
//		System.out.println("강감찬의 국어,영어,수학,국사 점수를 순서대로 입력하시오.");
//		for (int j=0;j<4;j++) { 
//			int num = s.nextInt();
//			arr[1][j]=num;
//		}
//		System.out.println("을지문덕의 국어,영어,수학,국사 점수를 순서대로 입력하시오.");
//		for (int j=0;j<4;j++) { 
//			int num = s.nextInt();
//			arr[2][j]=num;
//		}
//		System.out.println("권율의 국어,영어,수학,국사 점수를 순서대로 입력하시오.");
//		for (int j=0;j<4;j++) { 
//			int num = s.nextInt();
//			arr[3][j]=num;
//		}
//		for(int j=0;j<4;j++) { 
//			sum+=arr[0][j];
//		}
//		System.out.println("구분" + "\t" + "이순신" + "\t" + "강감찬" + "\t" + "을지문덕" + "   "+ "권율" + "\t"+ "총점");
//		System.out.println("국어"+ "\t   " + arr[0][0] + "\t   " + arr[1][0] + "\t   " + arr[2][0] + "\t    "+ arr[3][0] + "\t "+ sum);
//		sum=0;
//		for(int j=0;j<4;j++) { 
//			sum+=arr[1][j];
//		}
//		System.out.println("영어"+ "\t   " + arr[0][1] + "\t   " + arr[1][1] + "\t   " + arr[2][1] + "\t    "+ arr[3][1] + "\t "+ sum);
	}

}
