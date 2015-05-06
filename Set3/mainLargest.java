public class mainLargest {
	public static void main(String args[]) {
		int arr[] = {4,7,1,3,9,12,2};
		nLargest obj = new nLargest(arr);
		int largest = obj.nthLargest(1);
		System.out.println(largest);
	}
}