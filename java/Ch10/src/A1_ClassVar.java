class InstCnt { 
	static int instNum = 0; //static 변수
//	int instNum = 0;       	//class 변수
	public InstCnt() { 
		instNum++;
		System.out.println("인스턴스 생성 : " + instNum);
	}
}

public class A1_ClassVar {

	public static void main(String[] args) {
		InstCnt cnt1 = new InstCnt();
		InstCnt cnt2 = new InstCnt();
		InstCnt cnt3 = new InstCnt();
	}

}
