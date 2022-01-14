package Sort;

import java.util.Scanner;

public class MergeArray2 {

	static int[]buff; //임시 배열 : 병합하기위한 용도
	//재귀적으로 병합정렬
	static void mergeSort2(int []a,int left, int right) {//전체 배열의 수를 모른채로 받음
		if(left<right) {
			int i;
			int center=(left+right)/2;
			int p=0;
			int j=0;
			int k=left;
			
			mergeSort2(a,left,center);//반 나눈 배열의 왼쪽 부분, 앞 부분을 병합정렬
			mergeSort2(a,center+1,right);//반 나눈 배열의 오른쪽 부분, 뒷 부분을 병합정렬
			
			for(i=left; i<=center;i++)
				buff[p++]=a[i];
			while (i<=right&&j<p)//p == 반 나눈값
				
				a[k++]= (buff[j]<=a[i]?buff[j++]:a[i++]);//작은 값부터 넣음, 병합정렬부분
			while (j<p)
				a[k++]=buff[j++]; //남은 값 복사
		}
	}
	static void mergeSort_2(int[]a,int n) { //버퍼를 생성해서 작업할수있게 만들어줌, mergeSort2를 실행,전체 배열의 수를 알려줌, 버퍼를 비움
		buff=new int [n];
		mergeSort2(a,0,n-1);
		buff=null;
	}
	
	public static void main(String[] args) {
		Scanner se=new Scanner(System.in);
		
		System.out.println("병합 정렬");
		System.out.print("배열 갯수: ");
		int num=se.nextInt();
		int[]x=new int [num];
		
		for(int i=0; i<num;i++) {
			System.out.print("x["+i+"]: ");
			x[i]=se.nextInt();
		}
		mergeSort_2(x,num);
		
		System.out.println("오름차순으로 정렬했습니다.");
		for(int i=0; i<num;i++)
			System.out.println("x["+i+"]= "+x[i]);
	}

}
