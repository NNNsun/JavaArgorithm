package JoAlgorithm;
//stable함

public class Merge extends AbstractSort {

	private static void merge(Comparable[] a, Comparable[] aux,int lo, int mid, int hi ) {
		//a[lo...mid]과 a[mid+1...hi]는 이미 정렬된 상태
		
		//aux[]에 a[]의 내용을 일단 복사해둔다
		for(int k=lo; k<=hi;k++)
			aux[k]=a[k]; 
		
		//aux[]배열을 비교하여 병합된 결과를 a[]배열에 다시 저장한다
		
		//i는 현재(aux) 가장 왼쪽, j는 현제(aux) 가장 오른쪽
		int i=lo, j=mid+1;
		
		//lo부터 hi까지 전체를 돈다
		for(int k=lo; k<=hi;k++) {
		//다끝났을 경우
			
			if(i>mid)						a[k]=aux[j++];
			else if(j>hi)					a[k]=aux[i++];
			
			
		//i와 j가 범위에서 돌고있을경우	
			//aux[j]가 aux[i]보다 작을경우, a에 aux[j]값을 넣고 j를 다음 idx로 넘긴다 
			else if(less(aux[j],aux[i]))	a[k]=aux[j++];
			
			//aux[j]가 aux[i]보다 클경우, a에 aux[i]의 값을 넣고 i를 다음 idx로 넘긴다
			else							a[k]=aux[i++];
		}
	}
	
	public static void main(String[] args) {
		//반반씩 정렬이 되어있는 array
		Comparable[] arr = {2,43,46,54,3124,35,43,57,426,500};
		Comparable[] arr2=new Comparable[10];
		merge(arr,arr2,0,(arr.length-1)/2,9);
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}

	}

}
