import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class A5_Write7ToFile {

	public static void main(String[] args) {
		try(OutputStream out = new FileOutputStream("data.dat")) {
		out.write(7);	
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}