package app;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * This is a simple sorting algorithm. 
 */
public class BubbleSort {
	
	/**
	 * This is the main function to show the bubble sort works
	 * @param args - not used
	 */
	public static void main(String[] args) {
		List<Integer> unsortedArrayOne = createList(10);
		
		System.out.println("Unsorted List One:  ");
		System.out.println(unsortedArrayOne.toString());
		
		betterBubbleSort(unsortedArrayOne);
		
		System.out.println("Sorted List One:  ");
		System.out.println(unsortedArrayOne.toString());
		
		List<Integer> unsortedArrayTwo = createList(25);
		
		System.out.println("Unsorted List Two:  ");
		System.out.println(unsortedArrayTwo.toString());
		
		betterBubbleSort(unsortedArrayTwo);
		
		System.out.println("Sorted List Two:  ");
		System.out.println(unsortedArrayTwo.toString());
	
		
	}
	
	/**
	 * This is a bubble sort, which has the the largest value 'bubble up'
	 * to the last position in the array.  It does it in place.
	 * @param a unsorted list of integers.
	 */
	public static void simpleBubbleSort(List<Integer> array){
		for(int i=0; i<(array.size()-1); i++) {
			for(int j = 0; j < array.size()-i-1; j++) {
				if(array.get(j) > array.get(j+1)) {
					int temp = array.get(j);
					array.set(j, array.get(j+1));
					array.set(j+1, temp);
				}
			}
		}
	}
	
	/**
	 * This is also a bubble sort, which short circuits if there are 
	 * no more values to bubble up.
	 * @param unsorted list of integers
	 */
	public static void betterBubbleSort(List<Integer> array) {
		boolean change = false;
		do {
			change = false;
			for(int i= 0; i<array.size()-1; i++) {
				if(array.get(i)>array.get(i+1)) {
					int temp = array.get(i);
					array.set(i, array.get(i+1));
					array.set(i+1, temp);
					change = true;
				}
			}
		}while(change);
	}
	
	/**
	 * Creates a list filled with random integers from 0 to 999
	 * @param total the size of the list to be returned
	 * @return list of integers
	 */
	public static List<Integer> createList(int total){
		List<Integer> array = new Random().ints(0,999).limit(total).boxed().collect(Collectors.toList());;
		return array;
	}

}
