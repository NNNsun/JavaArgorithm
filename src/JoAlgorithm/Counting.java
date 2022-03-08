package JoAlgorithm;
//중복되는 원소의 경우 사용
//키값이 0~K-1사이의 정수일 경우 적용 가능
//입력배열: A[n]
//임시배열: C[K]
//결과배열: B[n]

public class Counting {
	//K는 원소의 갯수
	public static int[]sort(int[]A,int K){
		int i,N=A.length;
		int[]C=new int[K], B=new int [N];
		
		
		//중복되는 원소를 C배열에 count한다.
		for(i=0;i<N;i++)C[A[i]]++;
		
		//앞에있는 수를 더하면서 현재까지의 누적값을 입력한다.
		//Stable한 정렬을 위해 인덱스를 매기는 작업이다.
		for(i=1;i<K;i++)C[i]+=C[i-1];
		
		//누적값을 빼면서 원하는 값을 Stable하게 정렳한다.
		//이때 뒤에섯부터 저장하는 이유는 앞에서 부터 오름차순으로 누적했기때문에
		//누적값을 빼면서 정렬하려면 뒤에서부터 빼면서 정렬해야 Stable한 정렬이 이루어진다.
		for(i=N-1;i>=0;i--)
			B[--C[A[i]]]=A[i];
		return B;
	}
	
	
	public static void main(String[] args) {
		int[]A= {10,4,5,8,1,8,3,6},B;
		B=Counting.sort(A, 11);
		for(int i=0;i<B.length;i++)
			System.out.print(B[i]+" ");
		System.out.println();
	}
	//시간, 공간 복잡도 O(N+K)
	//K의 그기가 N과 비슷하다면, O(N)복잡도 정렬 가능!
	//하지만 K=N^3이라면, 복잡도 =O(N^3)
	//K가 무지막지하게 크면 쓸모없는 알고리즘이다.
}
