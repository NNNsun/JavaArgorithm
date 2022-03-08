package JoAlgorithm;

public class Insertion extends AbstractSort {
	// 삽입정렬
	// 복잡도 : 선택정렬==삽입정렬
	//최약: 내림차순, 역순
	//최선: 오름차순, 정렬된 경우
	public static void sort(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, i, j - 1);
			}
		}
		assert isSorted(a);
	}

	public static void main(String[] args) {
		Integer[] a= {10,4,5,2,1,8,3,6};
		Insertion.sort(a);
		Insertion.show(a);
	}

}
