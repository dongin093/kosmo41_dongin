
public class ForInFor {

	public static void main(String[] args) {
//		for(int i = 0; i < 3; i++) {
//			System.out.println("-----------------------------");
//			for(int j = 0; j < 3; j++) {
//				System.out.print("[" + i + "," + j + "]");
//			}
//			System.out.print('\n');
//			}
		//������ ���
//		for(int i =2; i<10;i++) {
//			System.out.println("----------------------------");
//			for(int j = 1;j<10;j++) {
//				System.out.println(i + "x" + j + "=" + (i*j));
//			}
//			System.out.print('\n');
		//while ����
		int i=2;
		while(i < 10) {
			System.out.println("-------------------------");
			int j=1;
			while(j < 10) {
				System.out.println(i + "x" + j + "=" + (i*j));
				j++;
				}
			i++;
			System.out.print('\n');
		}
	 }
}