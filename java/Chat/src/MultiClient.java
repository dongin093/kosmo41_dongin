import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.omg.CORBA.portable.UnknownException;

public class MultiClient {

	public static void main(String[] args) throws UnknownException, IOException {

		System.out.println("이름을 입력해 주세요.");
		Scanner s3 = new Scanner(System.in);
		String s_name = s3.nextLine();

		try {
			String ServerIP = "localhost";
			if (args.length > 0)
				ServerIP = args[0];
			Socket socket = new Socket(ServerIP, 9999);
			System.out.println("서버와 연결이 되었습니다....");

			Thread receiver = new Receiver(socket);
			receiver.start();
			 new ChatWin(socket,s_name);
//			Thread sender = new Sender(socket, s_name);
//			sender.start();

		} catch (Exception e) {
			System.out.println("예외[MultiClient class]:" + e);
		}
	}

}