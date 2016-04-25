package ads.lab6;

import ads.lab5.BinaryHeap;
import ads.lab5.EmptyHeapException;

/**
 * A class for the heap sort algorithm.
 */
public class HeapSort {
	
	/**
	 * Sort the array in place using the heapsort algorithm
	 * Complexity: THETA( n.log(n) ) where n is the size of the array
	 * @throws EmptyHeapException 
	 */	
	public static <AnyType extends Comparable<AnyType>> void sort(AnyType[] array) throws EmptyHeapException {
		BinaryHeap binary = new BinaryHeap(array);
		for	(int i = 0; i< array.length; i ++){
			array[array.length - i-1] = (AnyType) binary.deleteExtreme();
		}
		
		
		
		
	}
}
