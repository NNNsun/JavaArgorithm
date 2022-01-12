package basic;

import java.util.Scanner;
//가우스의 덧셈
public class Exercise_03 {
	static int gaus(int a) {
		 int result=((1+a)*a)/2;
		 return result;
	}
	static int gaus2(int a, int b) {
		int result=0;
		if(a<b) {
			result=((a+b)*(b-a+1))/2;
		}else {
			result=((a+b)*(a-b+1))/2;
		}
		return result;
	}
	public static void main(String[] args) {
//		int n=7;
//		int sum=0;
//		for(int i=1; i<=n; i++) {
//			sum+=i;
//			if (i==7) System.out.print(i);
//			else System.out.print(i+"+");
//		}
//		System.out.println("="+sum);
		
		//가우스의 덧셈
		System.out.print("숫자 입력: ");
		Scanner sc = new Scanner(System.in);
		int n2;
		do {
			System.out.println("0보다 큰 숫자를 입력해 주세요");
			n2=sc.nextInt();
		}while(n2<=0);
		
		System.out.println(gaus(n2));
		
		System.out.println("두개의 숫자 입력: ");
		int t1=sc.nextInt();
		int t2=sc.nextInt();
		System.out.println(gaus2(t1,t2));
		

	}

}
