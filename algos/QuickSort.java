package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class QuickSort {

	/**
	 * main function used to show quicksort
	 * @param args not used
	 */
	public static void main(String[] args) {
		
		List<Integer> unsorted = createList(10);
		
		System.out.println("Here is the unsorted list:  ");
		System.out.println(unsorted.toString());
		
		List<Integer> sortedArray = quickSort(unsorted);

		System.out.println("Here is the sorted list:  ");
		System.out.println(sortedArray.toString());

	}
	
	/**
	 * QuickSort algorithm that uses a pivot value and sorts the
	 * array into 3 groups, items higher, equal and less than the
	 * pivot.  It then combines those groups at the end
	 * @param list of unsorted integers
	 * @return sorted list
	 */
	public static List<Integer> quickSort(List<Integer> array){
		
		if(array.isEmpty()) {
			return array;
		}
		else {
			List<Integer> answer = new ArrayList<>();
			List<Integer> less = new ArrayList<>();
			List<Integer> equal = new ArrayList<>();
			List<Integer> more = new ArrayList<>();
				
			int pivot = array.get(0);

			for(int a: array){
				if(a > pivot) more.add(a);
				if(a < pivot) less.add(a);
				if(a == pivot) equal.add(a);
			}

			less = quickSort(less);
			more = quickSort(more);
				
			answer.addAll(less);
			answer.addAll(equal);
			answer.addAll(more);

			return answer;	
		}
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
