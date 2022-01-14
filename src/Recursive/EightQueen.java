package Recursive;

public class EightQueen {//22.01.14_이해못함 ㅠㅠ
	static boolean[] flag_a=new boolean[8]; //모든 행의 갯수
	static boolean[] flag_b=new boolean[15];//모든 대각선의 갯수_1
	static boolean[] flag_c=new boolean[15];//모든 대각선의 갯수_2
	static int[] pos=new int[8];//각 열의 퀸의 위치
	
	static void print() {
		
		for (int i=0; i<8;i++) {
			System.out.printf("%2d",pos[i]);
		}
		System.out.println();
	}
	static void set(int i) {
		for(int j=0; j<8; j++) {
			if (flag_a[j]==false&&flag_b[i+j]==false&&flag_c[i-j+7]==false) {
				pos[i]=j;
				if(i==7) print();
				else {
					flag_a[j]=flag_b[i+j]=flag_c[i-j+7]=true;
					set(i+1);
					flag_a[j]=flag_b[i+j]=flag_c[i-j+7]=false;
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		set(0);
	}

}
