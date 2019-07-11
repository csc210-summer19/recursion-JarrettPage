import java.lang.reflect.Array;

// Jarrett Page
/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Jarrett Page
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 1) {
			return n;
		}
		if (n == k) {
			return 1;
		}
		return combinations(n - 1, k - 1) + combinations(n - 1, k);
	}

	// Complete recursive method intWithCommas that returns the argument
	// as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		if (n < 999) {
			return "" + n;
		}
		return intWithCommas(n / 1000) + "," + String.format("%03d", n % 1000);
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverse(x, 0, x.length - 1);
	}

	private void reverse(int[] x, int index, int len) {
		// Do NOT use a loop.
		if (index < len) {
			int temp = x[index];
			x[index] = x[len];
			x[len] = temp;
			reverse(x, index + 1, len - 1);
		}

	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		int min = a[0];
		int max = Integer.MIN_VALUE;
		int n = a.length - 1;
		return range(a, n, min, max);
	}

	private int range(int[] array, int n, int min, int max) {
		int result = max - min;
		if (n == -1) {
			return result;
		} else {
			if (array[n] < min) {
				min = array[n];
				return range(array, n - 1, min, max);
			} else if (array[n] > max) {
				max = array[n];
				return range(array, n - 1, min, max);
			}
		}
		return result;
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		// Need to send down 0 to keep track of the index
		boolean sorted = true;
		int n = nums.length - 1;
		if (check(nums, n) != 0) {
			return sorted;
		} else {
			sorted = false;
		}
		return sorted;
	}

	private int check(int[] array, int index) {
		if (index == 0 || index == -1) {
			return 1;
		}
		if (array[index] < array[index - 1]) {
			return 0;
		}
		return check(array, index - 1);
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		boolean located = true;
		int n = strs.length - 1;
		if (lostAnd(search, strs, n) != 0) {
			return located;
		} else {
			located = false;
		}
		return located;
	}

	private int lostAnd(String str, String[] array, int i) {
		if (i == 0 || i == -1) {
			return 0;
		}
		if (array[i].equals(str)) {
			return 1;
		}
		return lostAnd(str, array, i - 1);
	}
}
