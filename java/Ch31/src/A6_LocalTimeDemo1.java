import java.time.LocalTime;

public class A6_LocalTimeDemo1 {

	public static void main(String[] args) {
		// 현재 시각
		LocalTime now = LocalTime.now();
		System.out.println("지금 시각 : " + now);
		
		// 2시간 10분 뒤 화상미팅 예정
		LocalTime mt = now.plusHours(2);
		mt=mt.plusMinutes(10);
		
		//화상미팅시각
		System.out.println("화상미팅시각 : " + mt);
	}
}