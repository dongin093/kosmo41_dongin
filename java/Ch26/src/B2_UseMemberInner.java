interface Printable1 {
	void print();
}

class Papers1 {
	private String con;
	public Papers1 (String s) {con = s;}
	
	public Printable1 getPrinter() { 
		return new Printer();
	}
	private class Printer implements Printable1 {
		public void print() {
			System.out.println(con);
		}
	}
}

public class B2_UseMemberInner {

	public static void main(String[] args) {
		Papers1 p = new Papers1("서류 내용 : 행복합니다.");
		Printable1 prn = p.getPrinter();
		prn.print();
	}
}