public class Quiz9 {

	public static void main(String[] args) {
		int num=1;
		int sum=0;
		do {
			num++;
			if((num%2)!=0) {
				continue;
			}
			sum+=num;
		}while(num<=100);
		System.out.println("Â¦¼öÀÇ ÃÑ ÇÕ : " + sum);

	}

}
