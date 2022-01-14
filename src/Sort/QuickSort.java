package Sort;

import java.util.Arrays;

public class QuickSort {

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void quickSort(int[] a, int left, int right) {
		int pl = left; // 왼쪽 커서 설정
		int pr = right;// 오른쪽 커서 설정
		int x = a[(pl + pr) / 2];// 피벗 설정

		System.out.printf("a[%d]~a[%d]: {",left,right);
		for(int i=left; i<right;i++)
			System.out.printf("%d, ",a[i]);
		System.out.printf("%d}\n", a[right]);
		
		
		do {
			while (a[pl] < x)
				pl++;
			while (a[pr] > x)
				pr--;
			if (pl <= pr)
				swap(a, pl++, pr--);
		} while (pl <= pr);

		if (left < pr)
			quickSort(a, left, pr);
		if (pl < right)
			quickSort(a, pl, right);
	}

	public static void main(String[] args) {
		int[] a = new int[8];

		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 100);
		}
		System.out.print("퀵 정렬 전: ");
		System.out.println(Arrays.toString(a));
		quickSort(a, 0, (a.length - 1));
		System.out.print("오름차순으로 정렬했습니다: ");
		System.out.println(Arrays.toString(a));

	}

}
