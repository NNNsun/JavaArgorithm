package Stack_Queue;

//Integer 형 스택
class IntStack {
	private int max;   //스택 용량
	private int ptr;   //스택 포인터, 그냥 int 변수
	private int[] stk; //스택 본체
	
	//실행 시 예외: 스택이 비어 있음
	public class EmptyIntStackExcption extends RuntimeException{
		public EmptyIntStackExcption() {}
	}
	//실행 시 예외: 스택이 가득 참
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {}
	}
	//생성자
	public IntStack(int capacity) {//capcity: 용량
		ptr=0;
		max=capacity;
		try {
			stk=new int[max];			//스택 본체용 배열을 생성, stack element의 수 = stk[0]~stk[max-1]
		}catch (OutOfMemoryError e) {	//생성할수 없음
			max=0;
		}
	}
	//스택에 x를 push
	public int push(int x)throws OverflowIntStackException {
		if (ptr>=max) { //스택이 가득잤을 경우
			throw new OverflowIntStackException();
		}
		return stk[ptr++]=x;
		
	}
	//스택에서 데이터를 pop(정상에 있는 data하나를 꺼냄)
	public int  pop()throws EmptyIntStackExcption {
		if(ptr<=0)
			throw new EmptyIntStackExcption();
		return stk[--ptr];
	}
	//스택에서 데이터를 peek(정상에 있는 data를 훔쳐 봄)
	public int peek() throws EmptyIntStackExcption {
		if(ptr<=0)
			throw new EmptyIntStackExcption();
		return stk[ptr-1];
	}
	//스택에서 x를 찾아 인덱스(없으면 -1)반환
	public int indexOf(int x) {
		for(int i=ptr-1;i>=0;i--)
			if(stk[i]==x)
				return i;
			return -1;
	}
	//스택의 용량을 반환
	public int capacity() {
		return max;
	}
	//스택에 쌓여 있는 데이터 수를 반환
	public int size() {
		return ptr;
	}
	//스택이 비었는가?
	public boolean isEmpty() {
		return ptr<=0;
	}
	//스택이 가득 찾는가?
	public boolean isFull() {
		return ptr>=max;
	}
	//스택 안의 모든 데이터를 바닥->꼭대기 순서로 출력
	public void dump() {
		if(ptr<=0)
			System.out.println("스택이 비었습니다.");
		else {
			for(int i=0;i<ptr;i++)
				System.out.println(stk[i]+" ");
			System.out.println();
		}
	}
	
}
