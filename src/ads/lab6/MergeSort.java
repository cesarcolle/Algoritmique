package ads.lab6;

/**
 * A class for the recursive merge sort algorithm.
 */
public class MergeSort {

	/**
	 * Sort the array using the recursive merge sort algorithm.
	 * This algorithm is not in place and needs an auxiliary array of
	 * the same size than the array to sort
	 * Complexity: THETA( n.log(n) ) where n is the size of the array
	 */		
	public static <AnyType extends Comparable<AnyType>> void sort(AnyType[] array) {
		AnyType[] tmp = (AnyType[]) new Comparable[array.length];
		sort(array,tmp,0,array.length - 1);
	}
	
	/**
	 * Sort the array in the range [lo, hi] using the portion [lo, hi]
	 * of the auxiliary array tmp
	 * Complexity: THETA( n.log(n) ) where n = hi - lo + 1
	 */
	private static <AnyType extends Comparable<AnyType>> void sort(AnyType[] array, AnyType[] tmp, int lo, int hi) {
		int median = (lo+hi)/2;
		if (lo >= hi ){
			return;
		}
		sort(array, tmp, lo, median);
		sort(array, tmp, median+1, hi);
		merge(array, tmp, lo, median, hi);
		
		transfer(tmp, array, lo,hi);
	}
	
	/**
	 * Merge array[lo, mid] and array[mid+1, hi] into tmp[lo, hi]
	 * and copy back the result into array[lo, hi]
	 * Precondition: array[lo, mid] and array[mid+1, hi] are sorted
	 * Complexity: THETA( n ) where n = hi - lo + 1
	 */
	private static <AnyType extends Comparable<AnyType>> void merge(AnyType[] array, AnyType[] tmp, int lo, int mid, int hi) {
		System.out.println("je merge entre : " +lo+"  "+ hi);
		int i = lo;
		int j = mid+1;
		for (;i <= mid && j <= hi;){
			
			if (array[i].compareTo(array[j]) < 0){
				tmp[lo++] = array[i++];
			}
			else{
				tmp[lo++] = array[j++];
			}
			
		}
		while ( i <= mid){
			tmp[lo++] = array[i++];

		}
		
		while (j <= hi ){
			tmp[lo++] = array[j++];
		}
	}
	
	/**
	 * Copy the elements from tmp[lo, hi] into array[lo, hi]
	 * Complexity: THETA( n ) where n = hi - lo + 1
	 */
	private static <AnyType> void transfer(AnyType[] tmp, AnyType[] array, int lo, int hi) {
		for(int i = lo; i <= hi; i++){
			array[i] = tmp[i];
		}
	}
		
}
