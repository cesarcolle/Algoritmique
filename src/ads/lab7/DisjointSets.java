package ads.lab7;

/**
 * A class to handle disjoint sets
 */
public class DisjointSets {

	// FAther or siZE: if faze[i] >= 0, faze[i] is the father of i in the up-tree
	// else i is the root of the up-tree and -father[i] is the size of the up-tree
	private int faze[];
	
	// the current number of subsets
	private int numSets;
	
	/**
	 * builds a disjoint set system of size n with
	 * the n initial single-element sets
	 * {0}, {1}, {2}, ..., {n-1}
	 */
	public DisjointSets(int n) {
		faze = new int[n];
		numSets = n;
		for (int i = 0; i < n; i++){
			faze[i] = i;
			
		}

	}
	
	/**
	 * returns the current number of
	 * subsets in the disjoint set system
	 */
	public int numSets() {
		return numSets;

	}
	
	/**
	 * returns the root of the
	 * up-tree containing i doing
	 * path compression
	 */
	public int find(int i) {
		if (faze[i] == i){
			return i;
		}
		while( faze[i]  > 0){
			System.out.println("faze = " +faze[i]);
			i = faze[i];
		}
		
		return i;

	}
	
	/**
	 * performs the union of the two subsets
	 * of roots root1 and root2
	 */
	public void union(int root1, int root2) {
		faze[root2] = faze[root1];
		if (faze[root1] > 0){
			faze[root1] = -1;
		}
		
		faze[root1] = faze[root1] -1;

	}
	
	////////////// toString function, do not change this code!
	
	public String toString() {
		String s = "|";
		for ( int i = 0; i < faze.length; i++ )
			s += format(i) + "|";
		s += "\n+";
		for ( int i = 0; i < faze.length; i++ )
			s += "---+";
		s += "\n|";
		for ( int i = 0; i < faze.length; i++ )
			s += format(faze[i]) + "|";		
		return s;
	}
	
	private String format(int n) {
		if ( n >= 0 && n < 10 )
			return "  " + n;
		if ( n >= -9 )
			return " " + n;
		return Integer.toString(n);
	}	
}
