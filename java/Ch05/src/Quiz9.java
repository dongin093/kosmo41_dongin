
public class Quiz9 {

	public static void main(String[] args) {
		int sum=0;
		int num=0;
		do {		
		num++;
		if(num%2==0) {
			sum=sum+num;
		}
		}while(num<=100);
		System.out.println("Â¦¼öÀÇ °ªÀº"+ "="  + sum);
	}
}