import java.net.Socket;
import java.util.Scanner;

public class MultiClient5 {

	public static void main(String[] args) {
		System.out.println("이름을 입력해 주세요.");
		Scanner s = new Scanner(System.in);
		String s_name = s.nextLine();
		
		try {
			String ServerIP = "192.168.0.128";
			Socket socket = new Socket(ServerIP,9999);
			System.out.println("서버와 연결이 되었습니다....");
			
			Thread receiver = new Receiver5(socket);
			receiver.start();
			
			Thread sender = new Sender5(socket, s_name);
			sender.start();
		} catch (Exception e) {
			System.out.println("예외[MultiClient class]:" + e);
		}
	}

}