package JoAlgorithm;


//LSD(low자리)를 이용한 기수정렬
//시간복잡성 O(d*(n+r))
public class Radix {
	public static void sort(int[]A) {
		//i:for문에 사용함, exp: 자릿수를 올릴때 사용 현재는 1의자리부터 시작, n: for문을 돌릴때 사용
		int i,m=A[0], exp=1,n=A.length;
		
		//각 기수의 정렬 결과를 임시로 저장할 배열
		int[]B=new int[n];
		
		//자릿수(m)을 결정하기 위해 필요한 for문
		for(i=1; i<n;i++) {
			if(A[i]>m) m=A[i];
		}
		
		//m은 가장 큰수, exp는 점점 커짐(1->10->100...)
		//서로 나눴을때 0보다 큰 경우 즉, 존재하는 자릿수 끝까지 while문 실행
		while(m/exp>0) {
			//숫자는 0~9까지만 존재하기 때문에 C[10]
			int[]C=new int[10];
			
			//1의 자리부터 가장큰 자릿수까지 for문으로 파악한후 C에다가 count해준다
			for(i=0;i<n;i++) C[A[i]/exp%10]++;
			
			//stable하게 정렬하기위해 누적시킨 값을 C에 넣는다
			for(i=1;i<10;i++) C[i]+=C[i-1];//i=1부터 시작하여 누적한 값을 C[-1]자리에 넣어줌 
			
			//끝에서 부터 돌며(가장 큰 수)stable하게 B에 값을 임시로 저장한다, 배열의 뒤쪽부터 채워넣는다
			for(i=n-1; i>=0;i--) B[--C[A[i]/exp%10]]=A[i];
			
			//B의 값을 다시 A에 복사해준다
			for(i=0;i<n;i++)
				A[i]=B[i];
			
			//자릿수를 올리위한 부분
			exp*=10;
		}
	}
	public static void main(String[] args) {
		
		int[] arr = {2,43,46,3124,54,67,543,35,53,426,43};
		sort(arr);
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}

}
