package basic;
//직삼각형 출력하기
public class Exercise_06 {
	static void triagnleLB(int n) {
		for(int i=0; i<n;i++) {
			for(int j=0; j<=i;j++)
				System.out.print("*");
			System.out.println();
		}
	}
	static void triagnleLU(int n) {
		for(int i=0; i<n;i++) {
			for(int j=0; j<n-i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	static void triagnleRU(int n) {
		for(int i=0; i<n;i++) {
			for(int j=0; j<=i;j++) {
				System.out.print(" ");
			}
			for(int j=0; j<n-i;j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	//트리모양 출력하기
	static void spira(int n) {
		for(int i=1; i<=n;i++) {
			for(int j=1; j<=n-i+1;j++) {
				System.out.print(" ");
			}
			for(int j=1;j<=(i-1)*2+1;j++) {
				//System.out.print("*");
				System.out.print(i%10);
			}
				
			System.out.println();
		}
	}
						
	public static void main(String[] args) {
		int k=13;
		//triagnleLB(k);
		System.out.println("-----------------");
		//triagnleLU(k);
		//triagnleRU(k);
		spira(k);
	}

}
