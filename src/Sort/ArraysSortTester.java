package Sort;

import java.util.Arrays;

public class ArraysSortTester {
	
	//<클래스 객체 배열>
	//1.자연 정렬이 필요한 배열: 대이터의 대소괸계를 비교하여 정렬
	//static void sort(Object[]a);
	//static void sort(Object[]a,int fromIndex, int toIndex);
	
	//2.요소의 대소 관계를 비교할때 comparator c 를 이용하여 정렬
	//static <T> void sort(T[]a,Comparator<? super T> c)
	//static <T> void sort(T[]a,int toIndex, Comparator<? super T> c)
	
	
	public static void main(String[] args) {
		int[] a = new int[8];

		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 100);
		}
		System.out.print("오름차순 정렬 전: ");
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);//기본자료형 sort는 퀵정렬 알고리즘을 개선한 것이며, 안정적이지 않음!(동일한 값의 위치가 sorting 중 바뀔수도 있음)
		System.out.print("오름차순 정렬 후: ");
		System.out.println(Arrays.toString(a));

	}

}
