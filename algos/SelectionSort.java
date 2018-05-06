package app;


public class SelectionSort {

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {

		int unsortedArray[] = {2,4,9,6,5,1,8,3,7,0};
		
		System.out.printf("Testing selectionSort.\n\n");
		System.out.printf("Here is the array:\n");
		for(int a: unsortedArray) {
			System.out.printf("%d ", a);
		}
		
		selectionSort(unsortedArray);
		
		System.out.printf("\n\nSorted: \n");
		for(int a: unsortedArray) {
			System.out.printf("%d ", a);
		}

	}
	
	/**
	 * This is a basic selectionSort algo.  It loops over the array and finds the
	 * smallest value and places it in its appropriate place.
	 * @param arr - and array of integers
	 */
	public static void selectionSort(int[] arr) {
		for(int i=0; i<arr.length-1;i++) {
			int smallestIndex = i;
			int smallest = arr[i];
			for(int j = i+1; j<arr.length;j++) {
				if(arr[j] < smallest) {
					smallest = arr[j];
					smallestIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[smallestIndex];
			arr[smallestIndex] = temp;
		}
	}

}
