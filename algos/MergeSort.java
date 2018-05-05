package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * There are many examples of merge that can be found - this version uses the template from
 * http://rosettacode.org/.  This is simplified to use the Integer type.
 */
public class MergeSort {

	/**
	 * Main method showing list is sorted
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> unsortedArray = new ArrayList<>();
		unsortedArray.add(9);
		unsortedArray.add(2);
		unsortedArray.add(7);
		unsortedArray.add(4);
		unsortedArray.add(3);
		unsortedArray.add(8);
		unsortedArray.add(1);
		unsortedArray.add(5);
		unsortedArray.add(0);
		unsortedArray.add(6);
		
		System.out.println("Unsorted List:  ");
		System.out.println(unsortedArray.toString());
		
		List<Integer> sortedList = mergeSort(unsortedArray);
		
		System.out.println("Sorted List:  ");
		System.out.println(sortedList.toString());
	}
	
	/**
	 * This takes in a list of unsorted integers, recursively divides the list into two
	 * halves until the list is size 1 or 0, and then merges those lists by calling the
	 * merge method.
	 * @param array - list of integers to be sorted
	 * @return result - list of integers that has been sorted
	 */
	public static List<Integer> mergeSort(List<Integer> array) {
        if(array.size() <= 1) return array;
        
        int middle = array.size() / 2;
        List<Integer> left = array.subList(0, middle);
        List<Integer> right = array.subList(middle, array.size());
 
        right = mergeSort(right);
        left = mergeSort(left);
        List<Integer> result = merge(left, right);
 
        return result;
	}
	
	/**
	 * This method takes two lists and combines them into one, sorted from smallest
	 * to largest
	 * @param left - List of integers
	 * @param right - List of integers
	 * @return result - both left and right, combined in a sorted 
	 */
	public static List<Integer> merge(List<Integer> left, List<Integer> right) {
		List<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> itX = left.iterator();
        Iterator<Integer> itY = right.iterator();
        
        int x = itX.next();
        int y = itY.next();
        
        while (true) {
        		if(x <= y){
        			result.add(x);
        			if(itX.hasNext()){
        				x = itX.next();
        			}
        			else{
        				result.add(y);
        				while(itY.hasNext()){
        					result.add(itY.next());
        				}
        				break;
        			}
        		}
        		else{
        			result.add(y);
        			if(itY.hasNext()){
        				y = itY.next();
        			}
        			else{
        				result.add(x);
        				while (itX.hasNext()){
        					result.add(itX.next());
        				}
        				break;
        			}
        		}
        }
        return result;
    }		
}
