
public class Quiz3 {

	public static void main(String[] args) {
		System.out.println("7과9의 배수입니다.");
		for(int i=1 ; i<100 ; i++) {
			if(((i % 7) ==0) || ((i%9)==0)) {
				System.out.println(i);
			}
		}
	}

}
