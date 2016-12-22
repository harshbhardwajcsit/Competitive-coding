/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package loop_in_graph;

/**
 *
 * @author samsung
 */
import java.util.*;

public class Loop_in_graph {

     private int V; // No. of vertices
     int count=1;
     boolean have_cycle=false;
	// Array of lists for Adjacency List Representation
	private LinkedList<Integer> adj[];

        //stack for operations
        private Stack<Integer> stack=new Stack<Integer>();

        //map for checking if the node is already visited or not
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();

	// Constructor
	Loop_in_graph(int v)
	{
		V = v;
		adj = new LinkedList[v];
		for (int i=0; i<v; ++i)
			adj[i] = new LinkedList();
	}

	//Function to add an edge into the graph
	void addEdge(int v, int w)
	{
		adj[v].add(w); // Add w to v's list.
	}






	int DFS(int v)
	{

                if(map.containsKey(v)==true){

                    //this means node v is already visited
                  

                }
                else{map.put(v,v);   //mark node 'v' as visited
                count++;
                System.out.print(v+" is visited "+"\n");}



                //method to find all adjacent node of node
		//  for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext())
		{
			int n = i.next();
                        if(map.containsKey(n)==false){
			stack.push(n);}
                        else{have_cycle=true;}
		}




                if(count!=V+1){
		DFS(stack.pop());}
                else{
                        }
                return 0;
	}

	public static void main(String args[])
	{
		Loop_in_graph g = new Loop_in_graph(5);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
                /*
		g.addEdge(2, 3);
		g.addEdge(3, 0);
                g.addEdge(4, 1);
                g.addEdge(4, 3);
*/

		System.out.println("Following is Depth First Traversal "+
						"(starting from vertex 4)");

		g.DFS(0);

                System.out.println("The graph have cycle :"+g.have_cycle);

	}


}
