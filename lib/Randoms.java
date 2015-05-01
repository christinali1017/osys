package lib;

/**
 * Random functions
 * @author wish
 */
public class Randoms {
	/**
	 * @param n
	 * @return random from [0, n)
	 */
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	
	/**
	 * @param start: start index
	 * @param end: end index
	 * @return random from [start, end]
	 */
	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
	
	/**
	 * @return random boolean, true or false
	 */
	public static boolean randomBoolean() {
		return randomIntInRange(0, 1) == 0;
	}
	
	/**
	 * @param percent: percent of true
	 * @return true at percent rate
	 */
	public static boolean randomBoolean(int percent) {
		return randomIntInRange(1, 100) <= percent;
	}
	
	/**
	 * @param M: row of matrix
	 * @param N: column of matrix
	 * @param min: minimum value in the matrix
	 * @param max: maximum value in the matrix
	 * @return random matrix value in [min, max]
	 */
	public static int[][] randomMatrix(int M, int N, int min, int max) {
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = randomIntInRange(min, max);
			}
		}
		return matrix;
	}
	
	/**
	 * @param N: length of random array
	 * @param min: minimum value of the random array
	 * @param max: maximum value of the random array
	 * @return random array value in [min, max]
	 */
	public static int[] randomArray(int N, int min, int max) {
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = randomIntInRange(min, max);
		}
		return arr;
	}
	
	/**
	 * @param N: length of linked list
	 * @param min: minimum value of linked list
	 * @param max: maximum value of linked list
	 * @return random linked list of length N
	 */
	public static LinkedListNode randomLinkedList(int N, int min, int max) {
		LinkedListNode root = new LinkedListNode(randomIntInRange(min, max), null, null);
		LinkedListNode prev = root;
		for (int i = 1; i < N; i++) {
			int val = randomIntInRange(min, max);
			LinkedListNode next = new LinkedListNode(val, null, null);
			prev.setNext(next);
			prev = next;
		}
		return root;
	}

}
