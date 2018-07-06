class Outer {
	private static int num =0 ;
	static class Nested1 {  // static 네스티드 클래스
		void add(int n) { num+=n;} //Outer 클래스의 static 변수 공유!
	}
	static class Nested2 {  // static 네스티드 클래스
		int get() {return num;}
	}
}
public class A_StaticNested {

	public static void main(String[] args) {
		Outer.Nested1 nst1 = new Outer.Nested1();  //인스턴스 생성 방법!
		nst1.add(5);
		Outer.Nested2 nst2 = new Outer.Nested2();
		System.out.println(nst2.get());
	}

}
