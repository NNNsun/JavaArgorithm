package Recursive;

import java.util.Scanner;

public class Hanoi {
	
	static void move(int num, int from, int to, int other) {//갯수,시작기둥,목표기둥,나머지기둥
		if(num==0)return ;
		move(num-1,from,other,to);
		System.out.println("["+num+"]번째의 원반을 ["+from+"]번에서 ["+to+"]로 옮긴다.");
		move(num-1,other,to,from);
	}
	public static void main(String[] args) {
		System.out.print("숫자를 입력해 주세요: ");
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt();
		int start=1;
		int destination=3;
		int temp=2;
		System.out.println("맨 위가 [1]번째 원반입니다.");
		move(x,start,destination,temp);
	}

}
