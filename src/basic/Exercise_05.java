package basic;

import java.util.Scanner;
//자릿수 출력 알고리즘
public class Exercise_05 {

	public static void main(String[] args) {
		System.out.print("숫자를 입력해주세요: ");
		Scanner sc= new Scanner(System.in);
		String num=sc.next();
		System.out.println("그 수는 "+num.length()+"자리 입니다.");
	}

}
