
public class Quiz7 {

	public static void main(String[] args) {
		int [][] arr = {
				{1,2,3,4},
				{5,6,7,8}
		};
		for (int i = 0 ; i<2;i++) { 
			for (int j=0;j<4;j++) {
				System.out.print(arr[i][j] + "\t");
			}			System.out.println();
		}
		System.out.println();

		for (int j=0;j<4;j++) { 
			for (int i = 0 ; i<2;i++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

}