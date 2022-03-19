package JoAlgorithm;

public class MergeBU extends AbstractSort{
	private static void merge(Comparable[] in, Comparable[] out, int lo, int mid, int hi) {
		int i=lo, j=mid+1;
		for(int k=lo; k<=hi; k++) {
			if(i>mid)					out[k]=in[j++];
			else if(j>hi)				out[k]=in[i++];
			else if (less(in[j],in[i])) out[k]= in[j++];
			else						out[k]=in[i++];
		}
	}
	
	public static void sort(Comparable[]a) {
	Comparable[] src =a, dst= new Comparable[a.length],tmp;
		int N=a.length;
		for(int n=1;n<N;n*=2) {
			for(int i=0; i<N;i+=2*n)
				//정수일때, (4,4,3)일 경우 hi(N-1)을 실행하지 않는다
				merge(src,dst,i,i+n-1,Math.min(i+2*n-1, N-1));
			//swap과정
			tmp=src; src=dst; dst=tmp;
		}
		//arraycopy를 안쓰고 a=src로 사용 할 경우 : 주소만 복사, sort가 안 될 경우가 발생한다!
		if(src!=a) System.arraycopy(src, 0, a, 0, N);
	}
	
	
	public static void main(String[] args) {
		
		Comparable[] a = { 'M', 'E', 'R', 'G', 'E', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E' };
		Comparable[] aux = new Comparable[a.length];
		int lo=0;
		int hi=a.length-1;
		int mid=(a.length-1)/2;
		
		sort(a);
		System.out.print("MergeBU= ");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]);
		System.out.println();
		

	}

}
