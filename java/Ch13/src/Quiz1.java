import java.util.Scanner;

class Calc_A
{
	int nsum (int a ,int b)
	{
		return a+b;
	}
    int nmax (int a ,int b)
	{
	if(a<b)
	{
		return b;
	}
	else
	{
		return a;
	}
	}
	int nmin(int a ,int b)
	{		
	if(a>b) 
	{
		return b;
	}
	else {
		return a;
	}
	
	}
}

public class Quiz1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] num = new int [5];
		Calc_A M = new Calc_A();
		int nRtn1 = 0;
		int nRtn2 = 999999999;
		int nRtn3 = 0;
		for(int i=0;i<5;i++) {
			System.out.println((i+1) + "번째 숫자를 입력하시오.");
			num[i] = s.nextInt();
			nRtn1 = M.nmax(nRtn1,num[i]);
			nRtn2 = M.nmin(nRtn2,num[i]);
			nRtn3 = M.nsum(nRtn3,num[i]);
		}		
		System.out.println("5개 숫자의 최대값 : " + nRtn1);
		System.out.println("5개 숫자의 최소값 : " + nRtn2);
		System.out.println("5개 숫자의 합은 : " + nRtn3);
	}

}
