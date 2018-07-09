interface Calculate4 { 
	int cal (int a, int b) ; //값을 반환하는 추상 메소드
}
public class A4_TwoParamAndreturn {

	public static void main(String[] args) {
		Calculate4 c;
		c=(a,b) -> {return a+b;};			//return문의 중괄호는 생략불가!
		System.out.println(c.cal(4, 3));
		
		c=(a,b) -> a+b;						//연산결과가 남으면,별도로 명시하지 않아도 반환 대상이됨!
		System.out.println(c.cal(4, 3));
	}
}

//메서드 몸체에 해당하는 내용이 return문이면
// 그문장이 하나이더라도 중괄호의 생략이 불가능하다.