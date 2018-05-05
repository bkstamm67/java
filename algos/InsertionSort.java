package app;

public class InsertionSort {
	/**
	 * main method, shows insertionSort works
	 * @param args
	 */
	public static void main(String[] args) {
		
		int unsortedArray[] = {2,4,9,6,5,1,8,3,7,0};
		
		System.out.printf("Testing insertionSort.\n\n");
		System.out.printf("Here is the array:\n");
		for(int a: unsortedArray) {
			System.out.printf("%d ", a);
		}
		
		insertionSort(unsortedArray);
		
		System.out.printf("\n\nSorted: \n");
		for(int a: unsortedArray) {
			System.out.printf("%d ", a);
		}

	}
	
	/**
	 * Takes in an array of ints and sorts it smallest to largest
	 * @param array
	 */
	public static void insertionSort(int array[]) {
		int arraylength = array.length;
		for(int i = 1; i < arraylength; i++) {
			//Using a for loop
			for(int j = i ; j > 0 ; j--){
				if(array[j] < array[j-1]){
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
			
			//Also using a while loop
			/*
			int key = array[i];
			int j = i-1;

			while (j>=0 && array[j] > key){
				array[j+1] = array[j];
				j = j-1;
			}
			array[j+1] = key;
			*/
		}
	}
}
