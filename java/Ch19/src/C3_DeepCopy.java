class Point3 implements Cloneable {
	private int xPos;
	private int yPos;
	
	public Point3(int x, int y) {
		xPos = x;
		yPos = y;
	}
	public void showPosition() {
		System.out.printf("[%d,%d]",xPos,yPos);
		System.out.println();
	}
	public void changePos(int x, int y) {
		xPos = x;
		yPos = y;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Rectangle3 implements Cloneable { 
	public Point3 upperLeft;  //좌측 상단 좌표
	public Point3 lowerRight; //우측 하단 좌표
	
	public Rectangle3(int x1, int y1, int x2, int y2) {
		upperLeft = new Point3 (x1,y1);
		lowerRight = new Point3 (x2,y2);
	}
	
	//좌표 정보를 수정함
	public void changePos (int x1, int y1, int x2, int y2) {
		upperLeft.changePos(x1, y2);
		lowerRight.changePos(x2, y2);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// Object 클래스의 clone 메소드 호출결과를 얻음
		Rectangle3 copy = (Rectangle3)super.clone();
		//깊은 복사의 형태로 
		copy.upperLeft = (Point3)upperLeft.clone();
		copy.lowerRight = (Point3)lowerRight.clone();
		return copy;
	}
	// 직사각형 좌표 정보 출력
	public void showPosition() {
		System.out.println("좌측 상단 :");
		upperLeft.showPosition();
	
		System.out.println("우측 하단 :");
		lowerRight.showPosition();
		System.out.println();
}
	
}


public class C3_DeepCopy {

	public static void main(String[] args) {
		Rectangle3 org = new Rectangle3(1, 1, 9, 9);
		Rectangle3 cpy;
		
		try {
			cpy =(Rectangle3)org.clone();
			org.changePos(2, 2, 7, 7);
			org.showPosition();
			cpy.showPosition();
			
			if(org.equals(cpy))
				System.out.println("aaaaaa.");
			else
				System.out.println("bbbbbb.");
			if(org.lowerRight.equals(cpy.lowerRight))
				System.out.println("cccccc.");
			else
				System.out.println("dddddd.");
		}
		catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}

