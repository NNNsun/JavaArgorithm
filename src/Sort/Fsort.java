package Sort;

import java.util.Scanner;

//도수 정렬
public class Fsort {
	static void fSort(int[]a,int n, int max) { //배열, 배열길이, 데이터 중 가장큰 값
		int[] f=new int [max+1]; //누적도수
		int[] b=new int [n];	 //작업용 목적 배열
		
		for(int i=0; i<n; i++)		f[a[i]]++;			//1단계 도수분포표 만들기
		for(int i=1; i<=max; i++) 	f[i]+=f[i-1];		//2단계 누적도수분포표만들기 누적시키면서 배열구성
		for(int i=n-1;i>=0;i--)		b[--f[a[i]]]=a[i];  //3단계 목적 배열 만들기, 정렬 마침
		for(int i=0; i<n; i++)      a[i]=b[i];			//4단계 원래 배열로 다시 복사하기
	}
	
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("도수 정렬을 시작합니다.");
		System.out.print("인덱스 수: ");
		int nx=sc.nextInt();
		int[]x=new int[nx];
		
		for(int i=0; i<nx;i++) {
			do {								//한번 출력해준다.
				System.out.print("x["+i+"]: ");
				x[i]=sc.nextInt();
			}while (x[i]<0);					//0보다 작은 수 나오면 다시 입력하게 한다.
		}
		int max=x[0];
		for(int i=1; i<nx;i++)					//배열 데이터 중 가장 큰 값으로 max값 지정
			if(x[i]>max) max = x[i];
		fSort(x,nx,max);
		System.out.println("오름차순으로 정렬했습니다.");
		for (int i=0; i<nx; i++)
			System.out.println("x["+i+"]= "+x[i]);
	}

}
