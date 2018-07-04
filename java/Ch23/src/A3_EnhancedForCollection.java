
	import java.util.List;
	import java.util.LinkedList;

	public class A3_EnhancedForCollection {

		public static void main(String[] args) {
			List<String> list = new LinkedList<>();
			
			//인스턴스 저장
			list.add("Toy");
			list.add("Box");
			list.add("Robot");
			
			//인스턴스 참조
			for (String s : list) 
				System.out.print(s + '\t');
			System.out.println();
			
			//첫번째 인스턴스 삭제
			list.remove(0);
			
			//삭제후 인스턴스 참조
			for(String s : list)
				System.out.print(s+'\t');
			System.out.println();
		}
	}

	//배열기반 자료구조이지만 공간의 확보 및 확장은
	//ArrayList 인스턴스가 스스로 처리한다.