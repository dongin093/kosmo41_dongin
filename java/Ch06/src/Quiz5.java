import java.util.Scanner;

public class Quiz5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("단어를 입력해주세요");
		String word = s.next();
		String[] array_word = new String[word.length()]; // 스트링을 담을 배열
		String[] array_word1 = new String[word.length()];
		int i = 0;
		int j ;
		for( i=0;i<array_word.length;i++){ //스트링을 한글자씩 끊어 배열에 저장
			array_word[i] = Character.toString(word.charAt(i));
			System.out.print(array_word[i]);
			
		}
		System.out.println("");
		for(j=array_word.length-1;j>=0;j--) {
				array_word1[j] = Character.toString(word.charAt(j));
			
			System.out.print(array_word1[j]);
		}
		System.out.println("");
		if (array_word[i].equals(array_word1[j])) { 
			System.out.println("회문입니다.");
		}
		else {
			System.out.println("회문이 아닙니다.");
		}
		/*
		if ((array_word[i]==array_word1[j])) {
			System.out.println("회문입니다.");
		
		}
		else {
			System.out.println("회문이 아닙니다.");
			
		}*/


// 출력 테스트용… 실제 사용시 안써도 됨.
//		for(int i=0;i<array_word.length;i++){
//			System.out.print(array_word[i]);
//		}
		
	}
}