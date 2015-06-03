package GettingFromAToB;

public class WeightedGraphDemo
{

	public static void main(String[] args)
	{
	
		
		try
		{
			
		RandomWeightedGraph graph = new RandomWeightedGraph(100, 15, 100, new Vertex("ROOT"));
		graph.print();
		
		PathFinder p = new PathFinder();
		
		Vertex v1 = graph.getRandomVertex();
		Vertex v2 = v1;
		while(v1.equals(v2))
		{
			v2 = graph.getRandomVertex();
		}
		
		System.out.println("From " + v1 + " to " + v2);
		System.out.println("Shortest path: ");
		WeightedGraph shortestPath = p.findShortestPath(v1, v2);
		if(shortestPath != null)
			shortestPath.print();
		else
			System.out.println("No path");
		
		System.out.println("Cheapest path: ");
		WeightedGraph cheapestPath = p.findCheapestPath(v1, v2);
			if(cheapestPath != null)
				cheapestPath.print();
			else
				System.out.println("No path");

		
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Your number of edges too two damn high");
		}
	

		/*
		//Strecke AE
		Vertex A = new Vertex("A");
		Vertex B = new Vertex("B");
		Vertex C = new Vertex("C");
		Vertex D = new Vertex("D");
		Vertex E = new Vertex("E");
		
		A.addEdge(new Edge(100, A , B));
		B.addEdge(new Edge(100, B , C));
		A.addEdge(new Edge(1, A , D));
		D.addEdge(new Edge(1, D , E));
		E.addEdge(new Edge(1, E , C));
		
		WeightedGraph g = new WeightedGraph(A);
		PathFinder p = new PathFinder();
		System.out.println("Shortest path: ");
		p.findShortestPath(A, C).print();
		System.out.println("Cheapest path: ");
		p.findCheapestPath(A, C).print();
		*/
	}
}