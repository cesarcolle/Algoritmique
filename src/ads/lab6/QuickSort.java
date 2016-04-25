package ads.lab6;

import java.util.Random;

/**
 * A class for the quicksort algorithm
 */
public class QuickSort {
	
	private static final int CUTOFF = 10;
	
	/**
	 * Sort the array in place using the quicksort algorithm
	 */
	public static <AnyType extends Comparable<AnyType>> void sort(AnyType[] array) {
		sort(array, 0, array.length-1); 
		
	}

	/**
	 * Sort the portion array[lo,hi] in place using the quicksort algorithm
	 */	
	private static <AnyType extends Comparable<AnyType>> void sort(AnyType[] array, int lo, int hi) {
		if (lo < hi){
			int pivot = partition(array, lo, hi);
			sort(array, lo, pivot-1);
			sort(array, pivot+1, hi);
		}
		
	}

	/**
	 * Partition the portion array[lo,hi] and return the index of the pivot
	 * a pas constant, not the better way. 
	 * 1 - take a pivot : take the median between lo, hi, median I take the median value and I swap with lo.
	 * on a un indice p a gauche du trait et k a gauche du trait.
	 * k est la limite de l'intervalle a traiter
	 * 
	 * 
	 */
	private static <AnyType extends Comparable<AnyType>> int partition(AnyType[] array, int lo, int hi) {
		int k = lo+1;
		int p = lo;
		//swap(array, pivot, hi);
		while ( k <= hi){
			if ( array[k].compareTo(array[lo]) < 0){
				p=p+1;
				swap(array, p, k);
			}
			k = k+1;
		}
		swap(array, lo, p);
		return p;
	}

	/**
	 * Return the index of the median of { array[lo], array[mid], array[hi] }
	 */
	private static <AnyType extends Comparable<AnyType>> int median(AnyType[] array, int lo, int mid, int hi) {
		System.out.println(lo + " " + mid + " " + " "+hi);
		if (array[lo].compareTo(array[mid]) < 0 && array[lo].compareTo(array[hi]) > 0){
			return lo;
		}
		if (array[mid].compareTo(array[lo]) < 0 && array[mid].compareTo(array[hi]) > 0){
			return mid;
		}
		if (array[hi].compareTo(array[lo]) < 0 && array[mid].compareTo(array[mid]) > 0){
			return hi;
		}
		
		return lo;
		
	}
	
	/**
	 * Sort array[lo, hi] in place using the insertion sort algorithm
	 */
	private static <AnyType extends Comparable<AnyType>> void insertion(AnyType[] array, int lo, int hi) {
		
	}
	
	/**
	 * Swap array[i] and array[j]
	 */
	private static <AnyType> void swap(AnyType[] array, int i, int j) {
		AnyType tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
//    public static void main(String[] args) {
//    	Integer[] array = { 7,8,2,6,9,4,10,1};
//    	//partition(array, 0, array.length-1);
//    	sort(array);
//    	for	(int i = 0; i < array.length; i++){
//    		System.out.println(array[i]);
//    	}
//    	System.out.println("fin ");
//    }


}
