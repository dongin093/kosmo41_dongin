interface Printable3 {
	void print(String doc);
}

interface ColorPrintable3 extends Printable3 {
	void printCMYK(String doc);
}


// 새로운 프린터의 드라이버
class Prn909Drv3 implements  ColorPrintable3 {
	@Override
	public void print(String doc) {
		System.out.println("From MD-909 black & white ver");
		System.out.println(doc);
	}
	public void printCMYK(String doc) {
		System.out.println("From MD-909 CMYK ver");
		System.out.println(doc);
	}
}
public class B3_PrinterDriver {

	public static void main(String[] args) {
		String myDoc = "This is a report about...";
				
		ColorPrintable3 prn = new Prn909Drv3();
		prn.print(myDoc);
		
		System.out.println();
		prn.printCMYK(myDoc);
	}

}
