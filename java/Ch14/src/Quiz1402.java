import java.util.Scanner;

public class Quiz1402 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String Y = "h l y";
		while (true) {
		int max = 100;
		int min = 0;
		int guess = 0;
		System.out.println("1부터 100사이 숫자를 생각하세요.");
		System.out.println("생각한 숫자보다 크면 h라고 입력하세요.");
		System.out.println("생각한 숫자보다 작으면 l라고 입력하세요.");
		System.out.println("생각한 숫자가 맞으면 y라고 입력하세요.");	
		for(; ;) {
			guess = (max+min)/2;
			System.out.println("생각한 숫자가 "+ guess + " 입니까?");
			Y = sc.next();
			System.out.println(Y);
		if (Y.equals("h")) {
			max =guess;
			continue;
		}
		if (Y.equals("l")) { 
			min=guess;
			continue;
		}
		if (Y.equals("y")) {
			break;
		}
	}
		System.out.println("계속하려면 아무키나 누르시오");
		Y = sc.next();
		continue;
	}
}
}