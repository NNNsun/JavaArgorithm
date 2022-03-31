package JoAlgorithm;

public class BinarySearchST<K extends Comparable<K>,V> {
	private static final int INIT_CAPACITY=10;
	private K[]keys;
	private V[]vals;
	private int N;
	
	public BinarySearchST() {
		keys=(K[])new Comparable[INIT_CAPACITY];
		vals=(V[])new Comparable[INIT_CAPACITY];
	}
	public BinarySearchST(int capacity) {
		keys=(K[]) new Comparable[capacity];
		vals=(V[])new Object[capacity];
	}
	public boolean contains(K key) {return get(key) != null;}
	public boolean IsEmpty() {return N==0;}
	public int size() {return N;}
	
	private void resize (int capacity) {
		K[] tempk = (K[]) new Comparable[capacity];
		V[] tempv = (V[]) new Object[capacity];
		for(int i=0; i<N; i++) {
			tempk[i]=keys[i];
			tempv[i]=vals[i];
		}
		vals = tempv;
		keys=tempk;
	}
	
}
