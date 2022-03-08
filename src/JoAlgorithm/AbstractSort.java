package JoAlgorithm;

public class AbstractSort {
	public static void sort(Comparable[]a) {};
	
	protected static boolean less(Comparable v,Comparable w) {
		//compareTo는 비교값보다 기준값이 작으면 -1, 동일하면 0, 크면 1을 return한다.
		//기준값이 작으면 true
		//기준값이 크다면 false
		return v.compareTo(w)<0; //v가 기준값
	}
	protected static void exch(Comparable[] a, int i, int j) {
		//swap함수
		Comparable t = a[i]; a[i]=a[j];a[j]=t;
	}
	protected static void show(Comparable[] a) {
		//배열값 프린트
		for(int i=0; i<a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	protected static boolean isSorted(Comparable[] a) {
		
		
		for(int i=1; i<a.length; i++)
			if (less(a[i],a[i-1])) //a[i]가 기준값, a[i-1]이 비교값
				//참이면 false
				//왜냐하면 a[i-1]이 더 작아야하기 때문
				return false;
			//제대로 정렬되어있음
			return true;
	}
}


/*
 * Comparable 인터페이스의 예
 * 
 * public class Date implements Comparable<Date>{ private final int month;
 * private final int day; private final int year; public Date(int month, int
 * day, int year) { if(!isValid(month,day,year)) throw new
 * IllegalArgumentException("Invalid date"); this.month=month; this.day=day; } }
 */




















