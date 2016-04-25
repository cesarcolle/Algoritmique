package ads.lab6;

/**
 * A class for simple sorting methods
 */
public class SimpleSorting {

	public static  <AnyType extends Comparable<AnyType>> int findMin(AnyType[] array, int begin, int end){
		AnyType a = array[begin];
		int result = begin;
		for (int i = begin; i < end; i++){
			if (array[i].compareTo(a) < 0){
				a = array[i];
				result = i;
			}
			
		}
		return result;
		
	}
	
	
	/**
	 * Sort the array in place using the selection sort algorithm
	 */
	public static <AnyType extends Comparable<AnyType>> void selection(AnyType[] array) {
		int g = 0;
		int idMin;
		while ( g < array.length){
			System.out.println(array);
			idMin = findMin(array, g, array.length);
			swap(array, g, idMin);
			g++;
			
			
		}

	}
	
	/**
	 * Sort the array in place using the insertion sort algorithm
	 * l'invariant cherche 
	 */
	public static <AnyType extends Comparable<AnyType>> void insertion(AnyType[] array) {
		for (int i = 1; i < array.length; i++){
			for( int j = i; j >= 0 && array[j-1].compareTo(array[j])< 0 ; j++){
				swap(array, j, j-1);
				j--;				
			}
		}

	}
	
	/**
	 * Swap array[i] and array[j]
	 */
	private static <AnyType> void swap(AnyType[] array, int i, int j) {
		AnyType tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
