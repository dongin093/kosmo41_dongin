//
//public class NullPointer {
//
//	public static void main(String[] args) {
//		String str = null;
//		System.out.println(str);
//		int len = str.length();
//	}
//
//}
// 오류나는 수식

public class NullPointer {

	public static void main(String[] args) {
		String str = null;
		System.out.println(str);
		if (str != null) {
			int len = str.length();
		}
	}
}
// 오류 안나는 수식