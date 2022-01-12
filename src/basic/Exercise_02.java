package basic;

import java.util.Scanner;

class Median{
	static int med3(int a, int b, int c) {
		if(a>=b)
			if(b>=c)
				return b;
			else if (a<=c)
				return a;
			else
				return c;
		else if(a>c)
			return a;
		else if (b>c)
			return c;
		else
			return b;
	}
}

public class Exercise_02 {

	public static void main(String[] args) {
		System.out.print("입력:");
		Scanner sc =new Scanner(System.in);
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		int num3=sc.nextInt();
		Median x= new Median();
		System.out.println("미들 값: "+x.med3(num1,num2,num3));

	}

}
