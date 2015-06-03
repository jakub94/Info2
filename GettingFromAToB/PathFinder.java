package GettingFromAToB;

import java.util.ArrayList;

public class PathFinder
{
	private ArrayList<AdjVertex> vertices;
	private boolean considerWeight;
	private Vertex rootVertex;

	public PathFinder()
	{
		vertices = new ArrayList<>();
	}

	private class AdjVertex
	{
		public AdjVertex(int value, Vertex current, Vertex predecessor)
		{
			this.value = value;
			this.current = current;
			this.predecessor = predecessor;

		}
		int value;
		Vertex current;
		Vertex predecessor; 
	}


	public WeightedGraph findShortestPath(Vertex start, Vertex end)
	{
		return findPath(start, end, false);
	}

	public WeightedGraph findCheapestPath(Vertex start, Vertex end)
	{
		return findPath(start, end, true);
	}

	private WeightedGraph findPath(Vertex start, Vertex end, boolean considerWeight)
	{
		reset();
		this.considerWeight = considerWeight;
		wrapperMethod(start);

		if(getCorrespondingAdj(end) != null)
			return constructPathWrapper(new Vertex(end.getName()));


		return null;
	}

	private WeightedGraph constructPathWrapper(Vertex end)
	{
		constructPath(end);
		return new WeightedGraph(rootVertex);
	}

	private AdjVertex getCorrespondingAdj(Vertex vertex)
	{
		for(AdjVertex adj : vertices)
		{
			if(adj.current.getName().equals(vertex.getName()))
				return adj;
		}
		return null;
	}

	private void wrapperMethod(Vertex start)
	{
		indexPath(null, start, 0);
	}

	private void indexPath(Vertex predecessor, Vertex current, int value)
	{
		if(isBestPathSoFar(current, value))
		{
			AdjVertex old = getCorrespondingAdj(current);
			if(old != null)
				vertices.remove(old);

			vertices.add(new AdjVertex(value, current, predecessor));

			if(considerWeight)
				for(Edge edge : current.getEdges())
					indexPath(current, edge.getEnd(), value + edge.getWeight());
			else
				for(Edge edge : current.getEdges())
					indexPath(current, edge.getEnd(), value + 1);
		}		
	}

	private boolean isBestPathSoFar(Vertex vertex, int value)
	{
		AdjVertex v = getCorrespondingAdj(vertex);
		if(v != null)
			return value < v.value;
		else
			return true;
	}

	private void reset()
	{
		this.vertices = new ArrayList<AdjVertex>();
		this.rootVertex = null;
	}

	private void constructPath(Vertex current)
	{
		AdjVertex adj = getCorrespondingAdj(current);
		if(adj.predecessor != null) 
		{
			Vertex pre = new Vertex(adj.predecessor.getName());
			ArrayList<Edge> edges = adj.predecessor.getEdges();
			for(Edge edge: edges)
			{
				if(edge.getEnd().getName().equals(current.getName()))
				{
					pre.addEdge(new Edge(edge.getWeight(), pre, current));
					constructPath(pre);
					break;
				}
			}
		}
		else
			rootVertex = current;
	}
}