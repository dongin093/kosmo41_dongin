import java.util.Scanner;

public class Quiz5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("단어를 입력해주세요");
		String word = s.next();
		String[] array_word = new String[word.length()]; // 스트링을 담을 배열
		for(int i=0,j=array_word.length;i<array_word.length;i++,j--){ //스트링을 한글자씩 끊어 배열에 저장
			array_word[i] = Character.toString(word.charAt(i));
			}
		int nMax1 = array_word.length;
		int nMax2 = array_word.length/2;
		for (int i=0;i<nMax2;i++) { 
			if(!array_word[i].equals(array_word[nMax1-1-i])) {
				System.out.println("회문이 아닙니다." );
				return;
			}
		}
		System.out.println("회문입니다.");
	}
}