package ads.lab7;

import java.util.*;

/**
 * A class for generating a random maze using disjoint sets
 */
public class Maze {

	// the number of rows
	private int rows;
	
	// the number of columns
	private int columns;
	
	// the full grid (i.e. all the possible inner edges)
	private List<Edge> grid;
	
	// the set of inner edges of the maze
	private Set<Edge> maze;
	
	/**
	 * generates a maze of size roiws X columns
	 * 
	 * if the edge exist on the ensemble. add to the maze. else add to an ensemble.
	 * 
	 */
	public Maze(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		maze = new HashSet<Edge>();
		grid = new ArrayList<Edge>();
		generateMaze();
	}
	
	/**
	 * This method generates the maze by filling the set maze.
	 * The method is the one explained during lecture.
	 * The grid is the collection from which the edges are randomly
	 * picked up, so it should be shuffled using the method
	 * Collections.shuffle
	 */
	private void generateMaze() {
		Random n = new Random();
	    for ( int i = 0; i < rows; i++){
	    	for (int j = 0; j < columns; j++){
	    		grid.add(new Edge(i, j));
	    	}
	    }
	    
	    Collections.shuffle(grid);
	    int x;
	    int y;
	    int racine1;
	    int racine2;
	    DisjointSets set = new DisjointSets(grid.size());
	    for (int i = 0; i < grid.size(); i++){
	    	x = grid.get(i).x;
	    	y = grid.get(i).y;
	    	racine1 = set.find(x);
	    	racine2 = set.find(y);
	    	set.union(racine1, racine2);
	    }
	    
	    
	    
//	    int cpt = 0;
//	    
//	    while ( cpt + columns < columns * rows){
//	    	maze.add(new Edge(cpt, cpt + columns));
//	    	cpt = cpt + 1;
//	    }
//	    cpt = 0;
//	    while ( cpt +1 < rows * columns){
//	    	maze.add(new Edge(cpt, cpt+1));
//	    	cpt ++;
//	    }
	   	   
	    
	}
	
	//////////////// toString (DON'T CHANGE THIS PART)
	
	/**
	 * returns a String representation of the maze
	 */
	public String toString() {
		String s = topbot();
		for ( int i = 0; i < rows - 1; i++ )
			s += vertical(i) + horizontal(i);
		return s += vertical(rows - 1) + topbot();
	}
	
	
	/**
	 * returns the top-bottom line of the maze
	 */
	private String topbot() {
		String s = "+";
	    for ( int i = 0; i < columns; i++ )
	    	s += "--+";
	    return s + "\n";
	}
	
	/**
	 * returns the String representation of
	 * the vertical edges of row number 'row'
	 */
	private String vertical(int row) {
		String s = null;
		if ( row == 0 )
			s = " ";
		else
			s = "|";
		for ( int i = row*columns; i < row*columns + columns - 1; i++ )
			if ( maze.contains(new Edge(i,i+1)) )
				s += "  |";
			else
				s += "   ";
	    if (row == rows - 1)
	        s += "   \n";
	    else
	        s += "  |\n";
		return s;
	}
	
	/**
	 * returns the String representation of
	 * the horizontal edges of row number 'row'
	 */	
	private String horizontal(int row) {
		String s = "+";
		for ( int i = row*columns; i < row*columns + columns; i++ )
			if ( maze.contains(new Edge(i,i+columns)) )
				s += "--+";
			else
				s += "  +";
		return s + "\n";
	}
	
	//////////////// main method: you can try various size of maze
	
	public static void main(String args[]) {
		Maze m = new Maze(3,5);
		System.out.println(m);
	}
}
