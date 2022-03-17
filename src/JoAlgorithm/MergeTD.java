package JoAlgorithm;

//Top-Down Merge: 맨위가 가장 작은단위, 내려가면서 정렬과 합병을 recursion한다
public class MergeTD extends AbstractSort {
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		// a[lo...mid]과 a[mid+1...hi]는 이미 정렬된 상태

		// aux[]에 a[]의 내용을 일단 복사해둔다
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];

		// aux[]배열을 비교하여 병합된 결과를 a[]배열에 다시 저장한다

		// i는 현재(aux) 가장 왼쪽, j는 현제(aux) 가장 오른쪽
		int i = lo, j = mid + 1;

		// lo부터 hi까지 전체를 돈다
		for (int k = lo; k <= hi; k++) {
			// 다끝났을 경우
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];

			// i와 j가 범위에서 돌고있을경우
			// aux[j]가 aux[i]보다 작을경우, a에 aux[j]값을 넣고 j를 다음 idx로 넘긴다
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];

			// aux[j]가 aux[i]보다 클경우, a에 aux[i]의 값을 넣고 i를 다음 idx로 넘긴다
			else
				a[k] = aux[i++];
		}
	}

	public static void sort(Comparable[] a) {
		
		//임시배열: merge의 결과를 잠시 저장하기 위한 공간
		Comparable[] aux = new Comparable[a.length];
		
		//밑의 sort와 동일, 가장 초기값
		sort(a, aux, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		//정렬이 완료된 경우
		if (hi <= lo)
			return;
		//재귀적으로 돌면서 mid의 범위를 조정해준다
		int mid = lo + (hi - lo) / 2;
		
		//mid이전 범위를 정렬한다
		sort(a, aux, lo, mid);
		
		//mid이후 범위를 정렬한다
		sort(a, aux, mid + 1, hi);
		
		//mid를 기준으로 정렬된 양쪽 범위를 정렬및 합병한다
		merge(a, aux, lo, mid, hi);
	}

	public static void main(String[] args) {
		Comparable[] a = { 'M', 'E', 'R', 'G', 'E', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E' };
		Comparable[] aux = new Comparable[a.length];
		int lo=0;
		int hi=a.length-1;
		int mid=(a.length-1)/2;
		
		//array 하나만 넣어도 두번째 sort()가 재귀적으로 호출되기 때문에 사용할수있는 함수
		sort(a);
		System.out.print("sort(a)= ");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]);
		
		System.out.println("\n");
		
		//정석sort()
		sort(a, aux,lo,hi);
		System.out.print("sort(a, aux,lo,hi)= ");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]);
	}

}
