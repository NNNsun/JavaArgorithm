package Stack_Queue;

import java.util.Scanner;

public class IntQueueTester {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		IntQueue data = new IntQueue(6);

		while (true) {
			System.out.println("현재 data 수: " + data.size() + " /" + data.capacity());
			System.out.print("(1)푸시  (2)팝  (3)피크  (4)덤프  (0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int x ;
			switch (menu) {
			case 1:
				System.out.print("데이터: ");
				x = stdIn.nextInt();
				try {
					data.enque(x);
				} catch (IntQueue.OverflowIntQueueExcepion e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;

			case 2:
				try {
					x=data.dnque();
					System.out.println("디큐한 데이터는 " + x + "입니다.");

				} catch (IntQueue.EmptyIntQueueExcepion e) {
					System.out.println("큐가 비어있습니다.");
				}
				break;
				
			case 3:
				try {
					x=data.peek();
					System.out.println("피크한 데이터는 "+ x+ "입니다.");

				} catch (IntQueue.EmptyIntQueueExcepion e) {
					System.out.println("큐가 비어있습니다.");
				}
				break;
			case 4:
				data.dump();
				break;
			}
		}

	}
}
