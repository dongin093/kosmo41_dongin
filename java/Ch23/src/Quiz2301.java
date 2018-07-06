import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Quiz2301 {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> kyo = new ArrayList<>();
		List<Integer> cha = new ArrayList<>();
		List<Integer> hap = new ArrayList<>();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);

		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		int n;
		//교집합 차집합 합집합을 구하시오.
		//교집합
		kyo.addAll(list1);			//kyo에 list1의 모든내용 저장
		kyo.retainAll(list2);		//kyo에 list1과 list2의 공통된 내용 남기고 나머지 제거
		//차집합
		cha.addAll(list1);			//cha에 list1의 모든내용 저장
		cha.removeAll(list2);		//cha에 list1과 list2의 공통된 내용 모두제거
		//합집합
		hap.addAll(list1);			//hap에 list1의 모든내용 저장
		hap.removeAll(list2);		//hap에 list1과 list2의 공통된 내용 모두제거
		hap.addAll(list2);			//hap에 list2의 모든내용 저장
		//-------------------------------
		System.out.println("list1=" + list1);
		System.out.println("list2=" + list2);
		System.out.println("kyo="+ kyo);
		System.out.println("cha=" + cha);
		System.out.println("hap=" + hap);
	}
}