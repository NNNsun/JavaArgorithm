package basic;
public class GH {

	public static void main(String[] args) {
		
		System.out.println("다이아몬드");
		
		int num=3;
		
		
		for(int i=0; i<=num;i++) {
			for(int k=num-i; k>0;k--)
				System.out.print(" ");
			
			for(int j=0;j<=i*2;j++) {
				System.out.print("*");
				
			}
			
			System.out.println();
		}
		
		for(int i=0; i<num;i++) {
			for(int k=0; k<=i;k++)
				System.out.print(" ");	
		
			for(int j=num+1;j>=i*2;j--) 
				System.out.print("*");
			System.out.println();
		}
		
		
	}
		
}
