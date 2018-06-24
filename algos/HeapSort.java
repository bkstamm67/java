package app;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * main method used to show the heap sort, while the methods making
 * up the heap sort methods was taken from http://rosettacode.org/
 * GeeksforGeeks.org also has a great video walking through the actions
 * of a heap sort to help make sense of what is happening
 */
public class HeapSort {

	/**
	 * Main method, to show heap sort works.
	 * @param args - not used
	 */
	public static void main(String[] args) {
		int unsortedArray[] = createList(15);
		
		System.out.printf("Testing heap sort.\n\n");
		System.out.printf("Here is the array:\n");
		for(int a: unsortedArray) {
			System.out.printf("%d ", a);
		}
		
		heapSort(unsortedArray);
		
		System.out.printf("\n\nSorted: \n");
		for(int a: unsortedArray) {
			System.out.printf("%d ", a);
		}
	}
	
	/**
	 * HeapSort uses the properties of a heap to find the largest item
	 * and place it at the bottom of the heap.  It then can continue with
	 * the remaining items, ultimately sorting the whole array.
	 * Comments in the code to help walkthrough the action. 
	 * @param arr int array
	 */
	public static void heapSort(int[] arr){
		//get the initial length of the array
		int count = arr.length;
		
		//use method to place array in max-heap order
		heapify(arr, count);
		//create a counter
		int end = count - 1;
		
		while(end > 0){
			//swap the root(maximum value) of the heap with the
			//last element of the heap
			int tmp = arr[end];
			arr[end] = arr[0];
			arr[0] = tmp;
			
			//put the heap back in max-heap order
			siftDown(arr, 0, end - 1);
			
			//decrement the size of the heap so that the previous
			//max value will stay in its proper place
			end--;
		}
	}
	
	/**
	 * Goes through the passed in array from the index
	 * @param arr int array
	 * @param count last index of array not sorted
	 */
	public static void heapify(int[] arr, int count){
		//start is assigned the index in a of the last parent node
		int start = (count - 2) / 2; 
	 
		while(start >= 0){
			//sift down the node at index start to the proper place
			//such that all nodes below the start index are in heap
			//order
			siftDown(arr, start, count - 1);
			start--;
		}
		//after sifting down the root all nodes/elements are in heap order
	}
	 
	/**
	 * Sift down the down the node at the start index so all indices are 
	 * in heap order
	 * @param arr array of ints 
	 * @param start index 
	 * @param end index
	 */
	public static void siftDown(int[] arr, int start, int end){
		//end represents the limit of how far down the heap to sift
		int root = start;
	 
		//While the root has at least one child
		while((root * 2 + 1) <= end){      
			//points to the left child
			int child = root * 2 + 1;
			
			//if the child has a sibling and the child's value is less than its sibling's
			//then point to the right child instead
			if(child + 1 <= end && arr[child] < arr[child + 1])
				child = child + 1; 
			
			//out of max-heap order
			if(arr[root] < arr[child]){     
				int tmp = arr[root];
				arr[root] = arr[child];
				arr[child] = tmp;
				root = child;
				//repeat to continue sifting down the child now
			}
			else return;
		}
	}
	
	/**
	 * Creates an array filled with random integers from 0 to 999
	 * @param total the size of the list to be returned
	 * @return array of integers
	 */
	public static int[] createList(int total){
		List<Integer> arrayList = new Random().ints(0,999).limit(total).boxed().collect(Collectors.toList());
		int[] array = arrayList.stream().mapToInt(i->i).toArray();
		return array;
	}

}
