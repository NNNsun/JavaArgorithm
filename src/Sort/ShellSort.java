package Sort;

import java.util.Arrays;

public class ShellSort {
//퀵정렬이 나오기전엔 가장 빠른 정렬이였음.
	static void shellSort(int []a, int n) {
		for(int h=n/2;h>0;h/=2)	//배열의 크기를 알아내서 반 자를 위치를 정하고 시작.
			for(int i=h;i<n;i++) {
				int j;
				int tmp=a[i];
				for(j=i-h;j>=0&&a[j]>tmp; j-=h)
					a[j+h]=a[j];
				a[j+h]=tmp;
			}
	}
	
	public static void main(String[] args) {
		int[] a = new int[8];

		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 100);
		}
		System.out.print("셸 정렬 전: ");
		System.out.println(Arrays.toString(a));
		shellSort(a,8);
		
		System.out.print("오름차순으로 정렬했습니다: ");
		System.out.println(Arrays.toString(a));
	}

}
