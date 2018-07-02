import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;

public class D1_IOExceptionCase1 {

	public static void main(String[] args) {
		Path file = Paths.get("D:\\Dongin093\\Study\\Simple.txt");
		BufferedWriter writer = null;
		
		try {
			//IOException 발생 가능
			writer = Files.newBufferedWriter(file);
			writer.write('A'); //IOException 발생 가능
			writer.write('Z'); //IOException 발생 가능
			
			if(writer != null)
				writer.close(); //IOException 발생 가능
			}
		catch(java.io.IOException e) {
			e.printStackTrace();
		}
	}
}