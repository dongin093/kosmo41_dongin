
public class Quiz10 {

	public static void main(String[] args) {
		int [][] arr= new int [4][4];
		int num=0;
		for (int i = 0;i<4;i++) {
			for (int j=0;j<4;j++) {
				num++;
				arr[i][j]=num;
			}
		}
		for (int i = 0;i<4;i++) {
			for (int j=0;j<4;j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0;i<4;i++) {
			for (int j=3;j>=0;j--) {
				System.out.print(arr[j][i] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 3;i>=0;i--) {
			for (int j=3;j>=0;j--) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 3;i>=0;i--) {
			for (int j=0;j<4;j++) {
				System.out.print(arr[j][i] + "\t");
			}
			System.out.println();
		}
	}
}