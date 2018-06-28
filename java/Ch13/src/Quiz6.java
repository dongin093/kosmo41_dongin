public class Quiz6 {

	public static void main(String[] args) {
		int [][] arr = new int[3][9];
		int num=0;
		for (int i=0; i<3 ; i++) 
		{
			for (int j=1;j<10;j++) 
			{ 
				num=((i+2)*(j));
				arr[i][j-1] = num;
			}
		}
		
		for (int i=0; i<3; i++) {
			for (int j=0;j<9;j++) { 
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}