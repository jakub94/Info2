package GettingFromAToB;

import java.util.ArrayList;
import java.util.Random;

public class RandomWeightedGraph extends WeightedGraph
{
	private ArrayList<Vertex> connected; 
	private Random random;

	public RandomWeightedGraph(int maxWeight, int vertices, int edges, Vertex root) throws IllegalArgumentException
	{
		super(root);
		
		if(edges > (vertices*(vertices-1))+1)
			throw new IllegalArgumentException();
		
		random = new Random();
		int dif = edges - vertices; 

		connected = new ArrayList<Vertex>(); 
		connected.add(root); 

		Vertex startVertex = root; 

		for(int i = 0; i < vertices-1; i++)
		{
			Vertex v = new Vertex("" + (char)(65 + i));
			Edge e = new Edge(random.nextInt(maxWeight), startVertex, v); 
			startVertex.addEdge(e);
			connected.add(v);
			startVertex = getAnyConnectedVertex(); 
		}

		for(int j = 0 ; j < dif; j++)
		{
			Vertex v1 = getAnyConnectedVertex(); 
			Vertex v2 = getAnyConnectedVertex();
			
			Edge e = new Edge(random.nextInt(maxWeight), v1, v2);
			
			if(v1.equals(v2) || v1.edgeAlreadyExists(e))
			{
				j--;
				continue;
			}
			
			v1.addEdge(e);
		}
	}

	private Vertex getAnyConnectedVertex() 
	{
		int index = random.nextInt(connected.size());
		return connected.get(index);
	}	
}