/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graph;

/**
 *
 * @author samsung
 */
import java.io.*;
import java.util.*;

public class Graph {

  private int V; // No. of vertices
 int count=1;
	// Array of lists for Adjacency List Representation
	private LinkedList<Integer> adj[];

        //stack for operations
        private Stack<Integer> stack=new Stack<Integer>();

        //map for checking if the node is already visited or not
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();

	// Constructor
	Graph(int v)
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
                        if(map.containsKey(n)==false){   //check if visited or not
			stack.push(n);}
		}
                if(count!=V+1){
		DFS(stack.pop()); // recussively call DFS with adjacent poped node
                }
                else{
                        }
                return 0;
	}

	public static void main(String args[])
	{
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal "+
						"(starting from vertex 2)");

		g.DFS(2);
	}

}
