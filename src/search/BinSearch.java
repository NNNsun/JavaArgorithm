package search;

import java.util.Scanner;
//이진검색
public class BinSearch {
	static int binSearch(int[]a,int n, int key) {//n:배열길이
		int pl=0; //좌
		int pr=n-1; //우
		
		while (pl<=pr) {
			int pc=(pl+pr)/2;
			if(a[pc]==key) return pc;
			else if (a[pc]<key) pl=pc+1;
			else pr=pc=1;
		}
		
		return -1; //없을시
	}
	public static void main(String[] args) {
		Scanner stdIn=new Scanner(System.in);
		System.out.print("배열길이: ");
		int num=stdIn.nextInt();
		int[]x=new int [num];
		System.out.println("오름차순으로 입력하세요.");
		System.out.print("x[0]: ");
		x[0]=stdIn.nextInt();
		
		for (int i=1; i<num; i++) { //num:인스턴스 배열길이
			while(x[i]<x[i-1]) { //오름차순 검사 
				System.out.print("x["+i+"]: ");
				x[i]=stdIn.nextInt();
			} //오름차순 검사
		}
		System.out.print("검색할 값: ");
		int ky=stdIn.nextInt();
		int idx=binSearch(x, num, ky);
		if(idx==-1) System.out.println("그 값의 요소가 없습니다.");
		else System.out.println(ky+"은(는) x["+idx+"]에 있습니다.");
	}
}
