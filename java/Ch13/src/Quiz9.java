abstract class Clean {
	int bowl = 0;
	abstract void MyClean();
	
class Cleaner extends Clean
{	
	void MyClean()
	{ 
	for (int i=1;i<4;i++) 
	{
		if(arr[i-1]>arr[i])
		{
			bowl=arr[i+1];
			arr[i+1]=arr[i];
			arr[i]=bowl;
		}
	}
	}
}
}
public class Quiz9 {

	public static void main(String[] args) {
		int arr[] = {210,19,72,129,34};
		Clean clean = new Clean();
		for ( int i=0;i<4;i++) {
			MyClean();
		}
		for(int i =0; i<5;i++) {
			System.out.print(arr[i] + " ");
		}
	}
}

//public class Quiz9 {
//
//	public static void main(String[] args) {
//		int arr[] = {210,19,72,129,34};
//		int bowl = 0;
//		for ( int i=0;i<4;i++) {
//		if(arr[i]>arr[i+1])  {
//			bowl=arr[i+1];
//			arr[i+1]=arr[i];
//			arr[i]=bowl;
//			}
//		}
//		for ( int i=0;i<3;i++) {
//			if(arr[i]>arr[i+1])  {
//				bowl=arr[i+1];
//				arr[i+1]=arr[i];
//				arr[i]=bowl;
//				}
//			}
//		for ( int i=0;i<2;i++) {
//			if(arr[i]>arr[i+1])  {
//				bowl=arr[i+1];
//				arr[i+1]=arr[i];
//				arr[i]=bowl;
//				}
//			}
//		for(int i =0; i<5;i++) {
//			System.out.print(arr[i] + " ");
//		}
//	}
//}