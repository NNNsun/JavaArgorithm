package Stack_Queue;
import java.util.Scanner;
public class IntStackTester {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntStack data = new IntStack(8); //capacity값 입력

		while (true) {
			System.out.println("현재 데이터 수: " + data.size() + " /" + data.capacity());
			System.out.print("(1)푸시  (2)팝  (3)피크  (4)덤프  (0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {
			case 1: // 푸시
				System.out.print("데이터: ");
				x = stdIn.nextInt();
				try {
					data.push(x);
				} catch (IntStack.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;
			case 2:
				try {
					data.pop();
				} catch (IntStack.EmptyIntStackExcption e) {
					System.out.println("스택이 비었습니다.");
				}
				break;
			case 3:
				try {
					x = data.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (IntStack.EmptyIntStackExcption e) {
					System.out.println("스택이 비었습니다.");
				}
				break;
			case 4:
				data.dump();
				break;
			}
		}
	}

}
