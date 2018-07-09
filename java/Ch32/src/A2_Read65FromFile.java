import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class A2_Read65FromFile {

	public static void main (String[] args) throws IOException {
		try {
			InputStream in = new FileInputStream("data.dat"); //입력스트림 생성
			int dat = in.read();	//데이터읽음
			in.close();				//입력스트림 종료
			
			System.out.println(dat);
			System.out.printf("%c",dat);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}