package animal;

public class Dog {
	public void welcome(zoo.Cat c) {
		c.makeSound(); //호출가능 ! 컴파일 성공!
//		c.makeHappy(); //호출불가 ! 컴파일 오류!
	}
}
