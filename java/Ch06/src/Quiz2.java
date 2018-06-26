import java.util.Random;

class MyRandom
{
	void randPrint1()
	{
		Random randomV1 = new Random();		

		int A = randomV1.nextInt(10)+1;
		int B = randomV1.nextInt(10);
		int C = randomV1.nextInt(10);
		System.out.println(A + "" + B + "" + C);
/*		if((A!=B) && (B!=C) && (A!=C)) 
		{
			System.out.println(Z);
		}*/

	}
}
public class Quiz2 {

	public static void main(String[] args) 
	{
		randomV1.randPrint1();
/*		for(;;) {
		Random randomV1 = new Random();		

		int Z = randomV1.nextInt(897)+102;
		int A = (Z/100);
		int B = (Z -A*100) /10;
		int C = (Z - (A*100) - (B*10));
		if((A!=B) && (B!=C) && (A!=C))
		{
			System.out.println(Z);
			break;
		}
	}*/
}
}