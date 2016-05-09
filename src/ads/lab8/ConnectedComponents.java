package ads.lab8;

import java.util.Iterator;

import ads.graph.*;

/**
 * A class to compute connected components of an undirected graph
 */
public class ConnectedComponents {

	/**
	 * returns the connected component
	 * label for each vertices of graph 'G'
	 */
	public static int[] find(UnDiGraph G) {
		int size = G.nbVertices();
		int[] array = new int[size];
		for (int i = 0; i < size; i++){
			array[i] = 0;
		}
		int compo = 1;
		for (int j = 0; j < size; j++){
			if (array[j] == 0){
				setComponent(G, j, compo++, array);
			}
			
		}
		
		return array;
	}
	
	/**
	 * fill in the array 'component' with label 'label' for all vertices
	 * of graph 'G' which are in the same connected component than 'u'
	 */
	private static void setComponent(UnDiGraph G, int u, int label, int component[] ) {
			component[u] = label;
			for (Integer a : G.adjacents(u)){
				if (component[a] == 0)
					setComponent(G, a, label, component);
			}			
	}
	
	// a main to check your code
	public static void main(String[] s) {
		UnDiGraph a = new UnDiGraph(11);
		a.addEdge(0,9);
		a.addEdge(0,5);
		a.addEdge(1,3);
		a.addEdge(1,8);
		a.addEdge(2,6);
		a.addEdge(2,4);
		a.addEdge(4,2);
		a.addEdge(5,9);
		a.addEdge(5,7);
		a.addEdge(7,9);
		int[] cc =  ConnectedComponents.find(a);
		int i = 0;
		for (int c : cc) {
			System.out.print("cc[" + i + "]:" + c + "  ");
			i++;
		}
		System.out.println();
		// expected output
		// cc[0]:1  cc[1]:2  cc[2]:3  cc[3]:2  cc[4]:3  cc[5]:1  cc[6]:3  cc[7]:1  cc[8]:2  cc[9]:1  cc[10]:4
		
		UnDiGraph b = new UnDiGraph(4);
		b.addEdge(1,2);
		cc =  ConnectedComponents.find(b);
		i = 0;
		for (int c : cc) {
			System.out.print("cc[" + i + "]:" + c + "  ");
			i++;
		}
		System.out.println();
		// expected output
		// cc[0]:1  cc[1]:2  cc[2]:2  cc[3]:3 

	}
}
