package basic;

import java.util.Scanner;
//값을 받아 Max, Min을 구하는 알고리즘
class Cul{
	int a;
	int b;
	int c;
	int d;
	int std;
	
	//Cul(){this.a=a; this.b=b; this.c=c; this.d=d;}
	public int minCul(int a, int b, int c){
		std=a;
		if(b<std) {std=b;}
		if(c<std) {std=c;}
		return std;
	};
	public int minCul(int a, int b, int c, int d){
		std=a;
		if(b<std) {std=b;}
		if(c<std) {std=c;}
		if(d<std) {std=d;}
		return std;
	};
	
	public int maxCul(int a, int b, int c, int d){
		std=a;
		if(b>std) {std=b;}
		if(c>std) {std=c;}
		if(d>std) {std=d;}
		return std;
	}
}


public class Exercise_01 {

	public static void main(String[] args) {
		System.out.print("값을 입력해 주세요= ");
		Scanner sc = new Scanner(System.in);
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		int num3=sc.nextInt();
		int num4=sc.nextInt();
		Cul n= new Cul();
		int ans1=n.maxCul(num1, num2, num3, num4);
		System.out.println(ans1);
		
		
	}

}
