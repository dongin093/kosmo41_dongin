class Box10<T extends Number> {
	private T ob;
	
	public void set (T o) {
		ob=o;
	}
	public T get() {
		return ob;
	}
}
public class B4_BoundedBox {

	public static void main(String[] args) {
		Box10<Integer>iBox = new Box10<>();
		iBox.set(24);
		
		Box10<Double> dBox = new Box10<>();
		dBox.set(5.97);
		
		System.out.println(iBox.get());
		System.out.println(dBox.get());
	}

}
