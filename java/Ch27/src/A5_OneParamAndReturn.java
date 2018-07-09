interface HowLong {
	int len(String s); //값을 반환하는 메소드
}
public class A5_OneParamAndReturn {

	public static void main(String[] args) {
		HowLong hl = s -> s.length();
		//int num = hl.len("I am so happy"); //이와같이 연산결과가 남는다.
		System.out.println(hl.len("I am so happy"));
	}
}