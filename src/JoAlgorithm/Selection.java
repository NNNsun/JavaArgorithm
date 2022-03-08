package JoAlgorithm;




public class Selection extends AbstractSort {
	
	public static void sort(Comparable[] a) {
	
		
		for(int i=0; i<a.length; i++) {
			int min=i;
			for(int j=i+1; j<a.length; j++) {
				if (less(a[j], a[min]))
					min=j;
			}
			//가장 작은것(j)을 찾으면 기준값(i)와 바꾼다.
			exch(a,i,min);
		}
		
		//false 일때 오류를 발생시킨다.
		assert isSorted(a);
	}
	public static void main(String[] args) {
		Integer[] a= {10,4,5,2,1,8,3,6};
		System.out.println("정렬 전");
		for(int i=0; i<a.length;i++) {
			
			System.out.print(a[i]+" ");
		}
		Selection.sort(a);
		System.out.println("\n"+"선택정렬 후");
		Selection.show(a);
		
	}

}








