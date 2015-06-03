package GettingFromAToB;

public class WeightedGraphDemo
{

	public static void main(String[] args)
	{
		RandomWeightedGraph graph = new RandomWeightedGraph(100, 5, 7, new Vertex("ROOT"));
		graph.print();
		
		PathFinder p = new PathFinder();
		p.getShortestPath(graph, graph.getRandomVertex(), graph.getRandomVertex()).print();
	}
}
