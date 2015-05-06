/*Create a class with: (1) a constructor that accepts an unordered array or vector of integers (your choice), and (2) a
/*method nthLargest() that returns the nth largest integer from the original vector.  For example, with an input of { 5,
/*3, 9, 4, 3, 3, 8, 3, 3 }, nthLargest(1) should return 9, and nthLargest(4) should return 4.  For inputs of zero or
/*greater than the size of the input, nthLargest() should throw an exception.  The input array will be very large (but
/*you can make a copy), and the input to nthLargest() may also be large, so a linear search algorithm is not acceptable.

Hint:  If you ask “may I sort the input”, the answer will be “yes, but there is a more efficient approach”.  If you ask
for a hint regarding the more efficient approach, I’ll ask if it is necessary to fully sort the input to implement
nthLargest().  If that doesn’t help, I’ll suggest you proceed with the sort- based approach, then explore other
possibilities.*/

import java.util.Random;
public class nLargest {
int arr[];
	public nLargest(int[] arr) {
		this.arr = arr;
	}

	public int nthLargest(int n) {
		if (n == 0 || n > arr.length) {
			throw new IllegalArgumentException();
		}
		Random rand = new Random();
		return nLargRec(arr, 0, arr.length-1, rand, n-1);
	}

	private int nLargRec(int[] arr, int min, int max, Random rand, int n) {
		//while (max >= min) {
			int pivotIndex = partition(arr, min, max, rand.nextInt(max - min +1) + min); //all smaller nos on left of pivot, bigger on right
			if (pivotIndex == n) { 
				return arr[pivotIndex];
			} else if (pivotIndex > n) { 
				return nLargRec(arr, min, pivotIndex-1, rand, n);
			} else {
				return nLargRec(arr, pivotIndex+1, max, rand, n);
			}
		//}
	}

	/*private int partition(int[] arr, int min, int max, int pivot) {
        int pivotVal = arr[pivot];
        while (min <= max) {
            while (arr[min]< pivotVal) {
                min++;
            }
            while (arr[max] > pivotVal) {
                max--;
            }
            if (min <= max) {
                int data = arr[min];
                arr[min] = arr[max];
                arr[max] = data;
                min++;
                max--;
            }
        }
        return min;
    }*/


  private int partition(int[] G, int first, int last, int pivot) {
  int data = arr[last];
       arr[last] = arr[pivot];
       arr[pivot] = data;
  for (int i = first; i < last; i++) {
    if (G[i] > G[last]) {
      data = arr[i];
       arr[i] = arr[first];
       arr[first] = data;
      first++;
    }
  }
  data = arr[first];
       arr[first] = arr[last];
       arr[last] = data;  
       return first;
}
}