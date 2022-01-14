package Sort;

import java.util.Arrays;

public class InsertionSort {// 안정적

	static void insertionSort(int[] a, int n) { //하나씩 넣으면서 계속 비교함
		for (int i = 1; i < n; i++) {
			int j;
			int tmp = a[i];
			for (j = i; j > 0 && a[j - 1] > tmp; j--)//큰 수는 하나씩 오른쪽으로 밀면서 정렬
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}

	public static void main(String[] args) {
		int[] a = new int[8];

		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 100);
		}
		System.out.print("단순 삽입 정렬 전: ");
		System.out.println(Arrays.toString(a));
		insertionSort(a, 8);
		System.out.print("단순 삽입 정렬 후: ");
		System.out.println(Arrays.toString(a));
	}

}
