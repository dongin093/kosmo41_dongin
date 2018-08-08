
public class test {

	public static void main(String[] args) {
		String str = "/to 홍길동 hello~Hi";
		String[] arr= str.split(" ");
		System.out.println(arr[0]);
		if (arr[0].equals("/to"))
			System.out.println("asd");
	}

}
