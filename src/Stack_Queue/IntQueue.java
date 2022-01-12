package Stack_Queue;

public class IntQueue {
	private int max; // 큐의 용량
	private int front; // 첫번째 element cursor
	private int rear; // 마지막 element cursor
	private int num; // 현재 data 수
	private int[] que; // 큐 본체

	// 실행 시 예외: 큐가 비어있음
	public class EmptyIntQueueExcepion extends RuntimeException {
		public EmptyIntQueueExcepion() {
		}
	}

	// 실행 시 예외 :큐가 가득 차있음
	public class OverflowIntQueueExcepion extends RuntimeException {
		public OverflowIntQueueExcepion() {
		}
	}

	// 생성자
	public IntQueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	// 큐에 data를 인큐
	public int enque(int x) throws OverflowIntQueueExcepion {
		if (num >= max)
			throw new OverflowIntQueueExcepion();
		que[rear++] = x;
		num++;
		if (rear == max)
			rear = 0;
		return x;
	}

	// 큐에 data를 디큐
	public int dnque() throws EmptyIntQueueExcepion {
		if (num <= 0)
			throw new EmptyIntQueueExcepion();
		int x = que[front++];
		num--;
		if (front == max)
			front = 0;
		return x;
	}

	// 큐에서 data를 피크(front data를 들여다 봄)
	public int peek() throws EmptyIntQueueExcepion {
		if (num <= 0)
			throw new EmptyIntQueueExcepion();
		return que[front];
	}

	// 큐에서 x를 검색하여 인덱스(찾지못하면 -1)를 반환
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			if (que[idx] == x) {
				return idx;
			}
		}
		return -1;
	}
	//검색한 데이터가 몇번째있는지 알려줌
	public int search(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			if (que[idx] == x)
				return i+1;
		}
		return 0;
	}
	
	// 큐 비움
	public void clear() {
		num = front = rear = 0;
	}

	// 큐의 용량을 반환
	public int capacity() {
		return max;
	}

	// 큐에 쌓여 있는 데이터 수를 반환
	public int size() {
		return num;
	}

	// 큐가 비어있나요?
	public boolean isEmpty() {
		return num <= 0;
	}

	// 큐가 가득 찼나요?
	public boolean isFull() {
		return num >= max;
	}

	// 큐 안의 모든 데이터를 프런트 ->리어 순으로 출력
	public void dump() {
		if (num <= 0)
			System.out.println("큐가 비어있습니다.");
		else {
			for (int i = 0; i < num; i++)
				System.out.print(que[(i + front) % max] + " ");
			System.out.println();
		}
	}
}
