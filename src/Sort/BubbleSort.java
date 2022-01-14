package Sort;

import java.util.Arrays;

public class BubbleSort {

	static void swap(int[] a, int idx1, int idx2) { // 위치를 바꿔준다.
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

	static void bublleSort(int[] a, int n) {
		for (int i = 0; i < n - 1; i++)
			for (int j = n - 1; j > i; j--)
				if (a[j - 1] > a[j]) {
					// 한 숫자를 기준으로 배열안에 있는 모든 숫자와 비교하면서,
					// 앞의 수가 뒤의 수보다 크다면 swap으로 둘의 바꿔주면서 한칸씩 앞으로 옮긴다.
					swap(a, j - 1, j);
					// System.out.println(Arrays.toString(a));
				}
	}

	static void bublleSort2(int[] a, int n) {
		for (int i = 0; i < n - 1; i++) {
			int exchg = 0;
			for (int j = n - 1; j > i; j--)
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					exchg++; //exchg추가버전: 스왑한 횟수를 알수있다.
				}
			if (exchg==0)break;
		}
	}
	static void bublleSort3(int[] a, int n) { //정렬된 것은 보지않늗다.
		int k=0;
		while (k<n-1) {
			int last=n-1;
				for (int j = n - 1; j > k; j--)
					if (a[j - 1] > a[j]) {
						swap(a, j - 1, j);
						last=j;
					}
				k=last;
			}
		}
	
	static void selectionSort(int [] a,int n) {
		for(int i=0; i<n-1;i++) {
			int min=i;					//정렬되지않은 부분에서 가장 작은 인덱스를 기록
			for(int j=i+1;j<n;j++) {
				if (a[j]<a[min])
					min=j;
			swap(a,i,min);				//아직 정렬되지 않은 부분의 첫 값과 가장 작은 값을 교환
			System.out.println(Arrays.toString(a));
			}	
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[8];

		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 100);
		}
		System.out.print("오름차순 버블 정렬 전: ");
		System.out.println(Arrays.toString(a));
		selectionSort(a, 8);
		System.out.print("버블 정렬 후: ");
		System.out.println(Arrays.toString(a));
	}

}
