package gr.duth.ee.euclid.datastructures.dijkstra;

// You will find {@link Arrays#fill(int[],int)} and {@link Arrays#fill(double[],double)} useful (but not necessary) to initialize all values in an array to a specific value
import java.util.Arrays;

/**
 * Represents an execution of the Dijkstra algorithm on a {@link DirectedDistanceGraph} and resulting in a {@link DijkstraResult}
 */
public class Dijkstra {
	/**
	 * Stores the graph
	 * WARNING: THIS MUST NOT BE MODIFIED BY STUDENTS!
	 */
	private DirectedDistanceGraph graph = null;

	/**
	 * Stores the result to be filled in
	 * WARNING: THIS MUST NOT BE MODIFIED BY STUDENTS!
	 */
	private DijkstraResult result = null;

	/**
	 * Stores the start node
	 * WARNING: THIS MUST NOT BE MODIFIED BY STUDENTS!
	 */
	private int startNode = -1;


	/**
	 * Initializes the Dijkstra algorithm object
	 * DO NOT MODIFY!
	 * @param graph The {@link DirectedDistanceGraph} on which to execute the algorithm
	 * @param startNode The node of the graph from which to start the Dijkstra algorithm
	 */
	public Dijkstra(DirectedDistanceGraph graph, int startNode){
		this.graph = graph;
		this.startNode = startNode;
		this.result = new DijkstraResult(this.graph);
	}


	/**
	 * Implements the Dijkstra algorithm
	 * @return An {@link DijkstraResult} object, containing the distances to all the node of the graph as well as the nodes through which this is achieved
	 */
	public DijkstraResult shortestPaths() {
		//Arxikopoihsh
		int n = graph.getNumOfNodes(); //Arithmos twn kombwn
		boolean[] visited = new boolean [n]; //Gia na kseroume poious kombous exoume episkeuthei
		boolean exitWhile = false; //Gia tin eksodo apo thn while_loop || true an exoume episkeuthei olous tous komvous
		
		// Arxikopoihsh nodeDistance kai visited
		for (int i=0; i<n; i++){
			result.nodeDistance[i] = Double.POSITIVE_INFINITY;
			visited[i] = false;
		}
		
		//Gia ton startNode
		result.nodeDistance[startNode] = 0;
		result.nodeThrough[startNode] = startNode;
		
		while (exitWhile == false){
			
			//Gia na vroume ton komvo me mikrotero nodeDistance
			double minD = Double.POSITIVE_INFINITY;
			int sourceNode = -1;
			for (int i=0; i<n; i++)
				if (visited[i]==false && result.nodeDistance[i]<minD){
					minD = result.nodeDistance[i];
					sourceNode = i;
				}
			if (sourceNode==-1){
				exitWhile = true;
				break;
			}
			else	
				visited[sourceNode] = true;
			
			//Elegxoume tous geitonikous kombous tou sourceNode kai analogws diamorfwnoume th diadromh
			for (int i=0; i<n; i++)
				if (graph.existsEdge(sourceNode, i)==true)
					if ((result.nodeDistance[sourceNode] + graph.getEdgeDistance(sourceNode,i)) < result.nodeDistance[i]){
						result.nodeDistance[i] = result.nodeDistance[sourceNode] + graph.getEdgeDistance(sourceNode, i);
						result.nodeThrough[i] = sourceNode;
					}
		}
		
		return result;
	}
}
